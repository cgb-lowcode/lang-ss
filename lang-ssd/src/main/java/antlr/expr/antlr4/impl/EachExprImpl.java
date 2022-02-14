package antlr.expr.antlr4.impl;

import antlr.CalException;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.antlr4.SSTreeAbs;
import antlr.expr.expr.*;
import cal.SSExprParser;
import org.antlr.v4.runtime.tree.ParseTree;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;

import java.util.List;

public class EachExprImpl extends SSTreeAbs {

    @Override
    public boolean support(ParseTree tree) {
        super.support(tree);
        return tree instanceof EachExprContext;
    }

    @Override
    public Expr expr()  {
        EachExprContext context = (EachExprContext)tree;
        return parseEach(context);
    }

    private Expr parseEach(EachExprContext ctx)  {
        //item变量名
        VariableContext var = ctx.variable();
        //获取列表
        UnitContext unit = ctx.unit();
        BaseExpr items = ExpressionManager.buildExpression(unit);
        //语句块
        BlockContext block = ctx.block();
        ExpressionBlock _expr = ExpressionManager.parseBlock(block);
        EachExprExpression expr = new EachExprExpression();
        expr.setExpression(_expr);
        String indexItem = var.Identifier().getText();
        expr.setNameItem(indexItem);
        expr.setItems(items);
        return expr;
    }
}