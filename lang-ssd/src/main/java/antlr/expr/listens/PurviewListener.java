package antlr.expr.listens;

import cal.SSExprBaseListener;
import cal.SSExprListener;
import cal.SSExprParser;
import cn.hutool.core.collection.CollUtil;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 语法树生成中函数调用权限控制
 * @author user
 */
public class PurviewListener extends SSExprBaseListener {

    public static Set<String> vars = new HashSet<>();
    public static Set<String> aggregations = new HashSet<>();
    public static Set<String> functions = new HashSet<>();

    @Override
    public void enterFunction(SSExprParser.FunctionContext ctx) {
        String funcName = ctx.Identifier().getText();
        //这里可以设置哪些函数是不能被调用的
        functions.add(funcName);
    }

    @Override
    public void enterDataset(SSExprParser.DatasetContext ctx) {
        String aggregation = ctx.aggregate().Identifier().getText();
        //这里判断数据集的增删改查权限
        aggregations.add(aggregation);
    }

    @Override
    public void enterStat(SSExprParser.StatContext ctx) {
        super.enterStat(ctx);
    }

    @Override
    public void enterVarAssign(SSExprParser.VarAssignContext ctx) {
        if(ctx.leftHandSide().variable()!=null) {
            String varName = ctx.leftHandSide().variable().Identifier().getText();
            vars.add(varName);
        }
    }
}
