package antlr.expr.builder.impl;

import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.VariableExpression;
import cal.SSExprParser;

public class VarIncDecExpressionBuilder implements ExpressionBuilder {
    @Override
    public BaseExpr build(SSExprParser.UnitContext unitContext) {
        String op = unitContext.op.getText();
        String text=unitContext.variable().Identifier().getText();
        VariableExpression varExpr=new VariableExpression(text,op);
        return varExpr;

    }
    @Override
    public boolean support(SSExprParser.UnitContext unitContext) {
        return unitContext.variable()!=null && unitContext.op!=null;
    }
}

