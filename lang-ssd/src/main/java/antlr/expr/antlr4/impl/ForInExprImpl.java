package antlr.expr.antlr4.impl;
import antlr.CalException;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.antlr4.SSTreeAbs;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.Expr;
import antlr.expr.expr.ExpressionBlock;
import antlr.expr.expr.ForInExpr;
import cal.SSExprParser;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class ForInExprImpl extends SSTreeAbs {
    @Override
    public boolean support(ParseTree tree) {
        super.support(tree);
        return tree instanceof ForInExprContext;
    }

    @Override
    public Expr expr()  {
        ForInExprContext forInCtx = (ForInExprContext)tree;
        return parseForIn(forInCtx);
    }

    private Expr parseForIn(ForInExprContext ctx)  {
        List<VariableContext> varList = ctx.variable();
        UnitContext unit = ctx.unit();
        BaseExpr items = ExpressionManager.buildExpression(unit);
        BlockContext block = ctx.block();
        ExpressionBlock _expr = ExpressionManager.parseBlock(block);
        ForInExpr expr = new ForInExpr();
        expr.setExpression(_expr);
        if(varList.size()==2){
            String indexName = varList.get(0).Identifier().getText();
            String indexItem = varList.get(1).Identifier().getText();
            expr.setNameItem(indexItem);
            expr.setNameIndex(indexName);
        }else if(varList.size() ==1){
            String indexItem = varList.get(0).Identifier().getText();
            expr.setNameItem(indexItem);

        }
        expr.setItems(items);
        return expr;
    }
}
