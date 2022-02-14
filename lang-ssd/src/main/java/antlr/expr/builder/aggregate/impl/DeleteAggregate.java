package antlr.expr.builder.aggregate.impl;

import antlr.CalException;
import antlr.expr.DataUtil;
import antlr.expr.builder.aggregate.AggregateUtils;
import antlr.expr.builder.aggregate.IAggregate;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.IntegerExpression;
import cal.SSExprParser;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import main.MyExprContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class DeleteAggregate implements IAggregate {
    /**
     * test23.delete({id:'xxx'})
     * CSE2D00102.delete() //删除所有该指标数据
     * CSE2D00102.delete({id:'xxx'})
     */
    @Override
    public BaseExpr expr(MyExprContext context, SSExprParser.DatasetContext ctx)  {
        //可以是数据源.表，表.，数据集ID.，也可以是指标代码
        List<TerminalNode> vars = ctx.Identifier();
        SSExprParser.Dataset_testsContext conds = ctx.dataset_tests(); //过滤套件列表
        String where = "";
        if(conds!=null){
            where += AggregateUtils.tests2str(context,conds);
        }
        String dsName = "",name="";
        if(vars.size() == 2){
            dsName = vars.get(0).getText();
            name = vars.get(1).getText();
        }else if(vars.size() ==1){
            name = vars.get(0).getText();
            //判断是否是宏观指标,如果是，直接返回
            if(DataUtil.isGjkCode(name)){
                int rows = DataUtil.removeDataByGjkCode(name,where);
                return new IntegerExpression(rows);
            }
        }else{
            throw new CalException("数据集名称必须指定!");
        }
        if(StrUtil.isEmpty(dsName)){
            dsName = "default";
        }
        //TODO:目前实现最简单的数据库表查询，以后可以扩展数据集名称等
        String sql = "DELETE ";
        sql+= " FROM " + name;
        sql+= " where 1=1 and ";
        if(StrUtil.isNotEmpty(where)){
            sql+= where;
        }
        System.out.println("sql:" + sql);
        try {
            int rows = DataUtil.execute(dsName,sql);
            return new IntegerExpression(rows);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new CalException("dataset delete 执行错误：" + ex.getMessage());
        }
    }

    @Override
    public String name() {
        return "delete";
    }
}
