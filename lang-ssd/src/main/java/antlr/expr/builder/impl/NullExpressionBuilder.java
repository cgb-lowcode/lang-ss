package antlr.expr.builder.impl;

import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.NullExpression;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;


public class NullExpressionBuilder implements ExpressionBuilder {
    @Override
    public BaseExpr build(UnitContext unitContext) {
        return new NullExpression();
    }

    @Override
    public boolean support(UnitContext unitContext) {
        return unitContext.simpleValue()!=null && unitContext.simpleValue().NULL()!=null;
    }
}
