package antlr.expr.func.impl;

import antlr.CalException;
import antlr.expr.func.Function;
import antlr.expr.tool.HtmlTableParser;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import main.MyExprContext;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class XPathFunction implements Function {
    @Override
    public Object execute(List<ExprData<?>> dataList, MyExprContext ctx)  {
        if(dataList!=null && dataList.size()>0) {
            Object v = dataList.get(0).getData();
            if(v instanceof String){
                String str = Convert.toStr(v);
                JXDocument jxDocument = null;
                if(str==null){
                    throw new CalException("xpath函数第一个参数不能为空");
                }
                if(str.startsWith("http://") || str.startsWith("https://")){
                    jxDocument = JXDocument.createByUrl(str);
                }else{
                    jxDocument = JXDocument.create(str);
                }

                if (dataList.size() == 2) {  //读取
                    Object ret = dataList.get(1).getData();
                    if(ret instanceof  String) {
                        String xpath = Convert.toStr(dataList.get(1).getData());
                        final List<JXNode> jxNodes = jxDocument.selN(xpath);
                        return jxNodes.stream().map(JXNode::asString).collect(Collectors.toList());
                    }else if(ret instanceof JSONObject){
                        /**
                         * 如果是JSON对象，格式如
                         * {
                         *      target:'table'
                         *
                         * }
                         */
                        JSONObject option = (JSONObject)dataList.get(1).getData();
                        if(option.containsKey("target")){
                            String target = Convert.toStr(option.get("target"));
                            String xpath = Convert.toStr(option.get("xpath"));
                            String tdAttr = Convert.toStr(option.get("tdAttr"));
                            if(target.toLowerCase().equals("table")){
                                if(StrUtil.isEmpty(tdAttr)){
                                    return table(str, xpath, null);
                                }else{
                                    String table = selOne(str, xpath);
                                    final List<List<List<String>>> tables = HtmlTableParser.parse(table, tdAttr);
                                    if (tables != null && tables.size() > 0) {
                                        return tables.get(0);
                                    }
                                    return new ArrayList<>();
                                }
                            }

                        }
                    }
                }
            }else {
                throw new CalException("xpath函数第一个参数必须XML字符串");
            }
        }
        throw new CalException("xpath至少需要一个参数！");
    }

    @Override
    public String name() {
        return "xpath";
    }

    private List<List<String>> table(String html, String xpath, String tdAttr) {
        String table = selOne(html, xpath);
        final List<List<List<String>>> tables = HtmlTableParser.parse(table, tdAttr);
        if (tables != null && tables.size() > 0) {
            return tables.get(0);
        }
        return new ArrayList<>();
    }

    private String selOne(String html, String xpath) {
        JXDocument jxDocument = JXDocument.create(html);
        return selOne(jxDocument, xpath);
    }
    private String selOne(JXDocument jxDocument, String xpath) {
        final JXNode jxNode = jxDocument.selNOne(xpath);
        if (jxNode == null) {
            return StrUtil.EMPTY;
        }
        return jxNode.asString();
    }
}
