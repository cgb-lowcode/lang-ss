package antlr.expr.tool;

import cn.hutool.core.util.StrUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 解析html中的table，返回二维字符串数据的矩阵
 */
public class HtmlTableParser {
    private static final String TABLE = "table";
    private static final String TR = "tr";
    private static final String TH = "th";
    private static final String TD = "td";
    private static final String COLSPAN = "colspan";
    private static final String ROWSPAN = "rowspan";


    /**
     * 解析html中的所有table标签，返回三维的数据
     *
     * @param html
     * @return
     */
    public static List<List<List<String>>> parse(String html) {
        return parse(html, null);
    }

    public static List<List<List<String>>> parse(String html, String tdAttr) {
        List<List<List<String>>> ret = new ArrayList<>();
        Document document = Jsoup.parse(html);
        for (Element table : document.select(TABLE)) {
            ret.add(parseTable(table, tdAttr));
        }
        return ret;
    }

    /**
     * 将table解析为二维数组
     *
     * @param tableEle
     * @param tdAttr
     * @return
     */
    private static List<List<String>> parseTable(Element tableEle, String tdAttr) {
        Table table = new Table();
        boolean text = StrUtil.isEmpty(tdAttr);
        for (Element tr : tableEle.select(TR)) {
            table.movetoNextRow();
            for (Element cell : tr.children()) {
                String tagName = cell.tagName();
                if (TD.equalsIgnoreCase(tagName) || TH.equalsIgnoreCase(tagName)) {
                    int rowspan = rowspan(cell);
                    int colspan = colspan(cell);
                    String cellContent;
                    if (!text && cell.hasAttr(tdAttr)) {
                        cellContent = cell.attr(tdAttr);
                    } else {
                        cellContent = cell.text();
                    }
                    table.addCellContent(rowspan, colspan, cellContent);
                }
            }
        }
        return table.getContent();
    }

    /**
     * 获取colspan
     *
     * @param cell
     * @return
     */
    private static int colspan(Element cell) {
        String colspan = cell.attr(COLSPAN);
        if (StrUtil.isEmpty(colspan)) {
            return 1;
        } else {
            return Integer.parseInt(colspan);
        }
    }

    /**
     * 获取rowspan
     *
     * @param cell
     * @return
     */
    private static int rowspan(Element cell) {
        String rowspan = cell.attr(ROWSPAN);
        if (StrUtil.isEmpty(rowspan)) {
            return 1;
        } else {
            return Integer.parseInt(rowspan);
        }
    }

    /**
     * Table数据对象
     */
    static class Table {

        private int row = -1;
        private int col = -1;
        private List<List<String>> content = new ArrayList<>();

        /**
         * @return 获取表格内容
         */
        public List<List<String>> getContent() {
            return content;
        }

        /**
         * 填入单元格数据
         *
         * @param rowspan
         * @param colspan
         * @param text
         */
        public void addCellContent(int rowspan, int colspan, String text) {
            int nextCol = nextCol();
            for (int r = row; r < row + rowspan; r++) {
                for (int c = nextCol; c < nextCol + colspan; c++) {
                    updateCellContent(r, c, text);
                }
            }
            col = nextCol + colspan;
        }

        /**
         * 更新单元格内容
         *
         * @param r
         * @param c
         * @param text
         */
        private void updateCellContent(int r, int c, String text) {
            List<String> rowList = getRow(r);
            while (c >= rowList.size()) {
                rowList.add(null);
            }
            rowList.set(c, text);
        }

        /**
         * @return 下一列号
         */
        private int nextCol() {
            List<String> rowList = getRow(row);
            int netCol = col;
            while (netCol < rowList.size() && rowList.get(netCol) != null) {
                netCol++;
            }
            return netCol;
        }

        /**
         * 获取一行
         *
         * @param row
         * @return
         */
        private List<String> getRow(int row) {
            if (row > content.size() - 1) {
                content.add(new ArrayList<>());
            }
            return content.get(row);
        }

        /**
         * 移动到下一行
         */
        public void movetoNextRow() {
            row++;
            col = 0;
        }
    }

}
