package antlr.expr.builder.aggregate.impl;

import antlr.CalException;
import antlr.expr.DataUtil;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.builder.aggregate.AggregateUtils;
import antlr.expr.builder.aggregate.IAggregate;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.IntegerExpression;
import cal.SSExprParser;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import main.MyExprContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class UpdateAggregate implements IAggregate {
    @Override
    public BaseExpr expr(MyExprContext context, SSExprParser.DatasetContext ctx)  {
        String where = "";
        List<TerminalNode> vars = ctx.Identifier();
        SSExprParser.PropertiesContext props = ctx.properties(); //数据集字段列表
        if(props.obj() == null){
            throw new CalException("insert 操作第一个参数必须是json对象！");
        }
        SSExprParser.Dataset_testsContext conds = ctx.dataset_tests(); //过滤套件列表
        if(conds!=null){
            where = AggregateUtils.tests2str(context,conds);
        }
        JSONObject params = (JSONObject) ExpressionManager.parsePropContext(props).run(context).getData();

        String dsName = "",name="";
        if(vars.size() == 2){
            dsName = vars.get(0).getText();
            name = vars.get(1).getText();
        }else if(vars.size() ==1){
            name = vars.get(0).getText();
            //判断是否是宏观指标,如果是，直接返回
            if(DataUtil.isGjkCode(name)){
                int rows = DataUtil.updateDataByGjkCode(name,params,where);
                return new IntegerExpression(rows);
            }
        }else{
            throw new CalException("数据集名称必须指定!");
        }
        if(StrUtil.isEmpty(dsName)){
            dsName = "default";
        }
        //TODO:目前实现最简单的数据库表查询，以后可以扩展数据集名称等
        String sql = "UPDATE ";
        sql+= " " + name + " SET ";
        String fields = "";
        Object[] fieldsValues = new Object[params.size()];
        int index = 0;
        for(String key : params.keySet()){
            fields += "," + key + "=?";
            fieldsValues[index++] = params.get(key);
        }
        if(fields.startsWith(",")){
            fields = fields.substring(1,fields.length());
        }
        sql += fields;
        if(StrUtil.isNotEmpty(where)) {
            sql += " WHERE " + where;
        }
        System.out.println("sql:" + sql);
        try {
            int rows = DataUtil.execute(dsName,sql,fieldsValues);
            return new IntegerExpression(rows);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new CalException("dataset update 执行错误：" + ex.getMessage());
        }
    }

    @Override
    public String name() {
        return "update";
    }
}
