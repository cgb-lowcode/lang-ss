package main;

import antlr.CalException;
import antlr.expr.ExpressionCondition;
import antlr.expr.ExpressionConditionList;
import antlr.expr.Tools;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.expr.*;
import antlr.model.Join;
import antlr.model.Op;
import antlr.model.Operator;
import cal.SSExprBaseVisitor;
import cal.SSExprLexer.*;
import cal.SSExprParser.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class MyCalVisitor extends SSExprBaseVisitor<Expr> {
    //入口程序
    @Override
    public Expr visitStat(StatContext ctx) {
        StringBuilder sb=new StringBuilder();
        List<ExpressionContext> exprs=ctx.expression();
        List<Expr> list=new ArrayList<Expr>();
        for(ExpressionContext exprContext:exprs){
            sb.append(exprContext.getText());
            Expr expr=visitExpression(exprContext);
            list.add(expr);
        }
        ExpressionBlock block=new ExpressionBlock();
        block.setExpressionList(list);
        block.setExpr(sb.toString());
        return block;
    }
    @Override
    public Expr visitExpression(ExpressionContext ctx) {
        try {
            return ExpressionManager.factor(ctx);
        } catch (CalException e) {
            e.printStackTrace();
        }
        return null;
    }
}

