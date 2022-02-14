package antlr.expr.builder.impl;

import antlr.expr.Tools;
import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.JSONExpression;
import antlr.expr.expr.NumberExpression;
import cal.SSExprParser;

public class JSONValueBuilder implements ExpressionBuilder {
    @Override
    public BaseExpr build(SSExprParser.UnitContext unitContext)  {
        if(unitContext.json()!=null){
            return new JSONExpression(unitContext.json());
        }else{
            return null;
        }
    }

    @Override
    public boolean support(SSExprParser.UnitContext unitContext) {
        return unitContext.json()!=null;
    }
}