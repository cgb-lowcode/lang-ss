package antlr.expr.builder.aggregate.impl;

import antlr.CalException;
import antlr.expr.DataUtil;
import antlr.expr.builder.aggregate.IAggregate;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.IntegerExpression;
import cal.SSExprParser;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import main.MyExprContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class ExecuteAggregate implements IAggregate {
    @Override
    public BaseExpr expr(MyExprContext context, SSExprParser.DatasetContext ctx)  {
        List<TerminalNode> vars = ctx.Identifier();
        SSExprParser.PropertiesContext props = ctx.properties(); //数据集字段列表
        SSExprParser.Dataset_testsContext conds = ctx.dataset_tests(); //过滤套件列表

        if(props.STRING() == null){
            throw new CalException("exuecute 操作必须是一个String参数！");
        }
        String dsName = "";
        if(vars.size() ==1){
            dsName = vars.get(0).getText();
        }else{
            throw new CalException("数据集名称必须指定!");
        }
        if(StrUtil.isEmpty(dsName)){
            dsName = "default";
        }
        String sql = props.STRING().getText();
        sql = sql.substring(1,sql.length()-1);
        System.out.println("sql:" + sql);
        try {
            int rows = DataUtil.execute(dsName,sql);
            return new IntegerExpression(rows);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new CalException("dataset execute 执行错误：" + ex.getMessage());
        }
    }

    @Override
    public String name() {
        return "execute";
    }
}
