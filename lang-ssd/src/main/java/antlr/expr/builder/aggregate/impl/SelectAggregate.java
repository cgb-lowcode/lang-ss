package antlr.expr.builder.aggregate.impl;

import antlr.CalException;
import antlr.expr.DataUtil;
import antlr.expr.builder.aggregate.AggregateUtils;
import antlr.expr.builder.aggregate.IAggregate;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.JSONExpression;
import cal.SSExprParser;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import main.MyExprContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class SelectAggregate implements IAggregate {
    @Override
    public BaseExpr expr(MyExprContext context, SSExprParser.DatasetContext ctx)  {
        //可以是数据源.表，表.，数据集ID.，也可以是指标代码
        List<TerminalNode> vars = ctx.Identifier();
        SSExprParser.PropertiesContext props = ctx.properties(); //数据集字段列表
        SSExprParser.Dataset_testsContext conds = ctx.dataset_tests(); //过滤套件列表
        SSExprParser.OrdersContext orders = ctx.orders();

        if(ctx.properties().obj()!=null){
            throw new CalException("在select操作中，字段列表只支持字符串！");
        }
        String propsStr = "";
        if(props!=null){
            propsStr = props.STRING().getText();
            propsStr = propsStr.substring(1,propsStr.length()-1);
        }else{
            propsStr = "*";
        }

        String orderStr = "";
        if(orders!=null){
            orderStr = orders.STRING().getText();
            orderStr = orderStr.substring(1,orderStr.length()-1);
        }


        String dsName = "",name="";
        if(vars.size() == 2){
            dsName = vars.get(0).getText();
            name = vars.get(1).getText();
        }else if(vars.size() ==1){
            name = vars.get(0).getText();
            //判断是否是宏观指标,如果是，直接返回
            if(DataUtil.isGjkCode(name)){
                String where = "";
                if(conds!=null){
                    where = AggregateUtils.tests2str(context,conds);
                }
                List rows = DataUtil.getDataByGjkCode(name,propsStr,where,orderStr);
                return new JSONExpression(JSONUtil.toJsonStr(rows));
            }
        }else{
            throw new CalException("数据集名称必须指定!");
        }
        if(StrUtil.isEmpty(dsName)){
            dsName = "default";
        }
        //TODO:目前实现最简单的数据库表查询，以后可以扩展数据集名称等
        String sql = "SELECT ";
        sql += propsStr;
        sql+= " from " + name;
        sql+= " where 1=1 ";
        if(conds!=null){
            sql += " and ";
            sql+= AggregateUtils.tests2str(context,conds);
        }
        sql+= "";
        if(StrUtil.isNotEmpty(orderStr)){
            sql+= " order by " + orderStr;
        }
        System.out.println("sql:" + sql);
        try {
            List<Entity> rows = DataUtil.query(dsName,sql);
            return new JSONExpression(JSONUtil.toJsonStr(rows));
        }catch(Exception ex){
            ex.printStackTrace();
            throw new CalException("dataset 执行错误：" + ex.getMessage());
        }
    }

    @Override
    public String name() {
        return "select";
    }
}
