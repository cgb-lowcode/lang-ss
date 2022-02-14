package antlr.expr.builder.impl;

import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.VariableAssignExpression;
import antlr.expr.expr.VariableExpression;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;

public class VariableExpressionBuilder implements ExpressionBuilder {
    @Override
    public BaseExpr build(UnitContext unitContext) {
        String text=unitContext.variable().Identifier().getText();
        VariableExpression varExpr=new VariableExpression(text);
        return varExpr;
    }
    @Override
    public boolean support(UnitContext unitContext) {
        return unitContext.variable()!=null && unitContext.op==null;
    }
}
