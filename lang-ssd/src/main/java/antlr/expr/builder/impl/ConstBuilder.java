package antlr.expr.builder.impl;

import antlr.CalException;
import antlr.expr.Tools;
import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.NumberExpression;
import cal.SSExprParser;

public class ConstBuilder implements ExpressionBuilder {
    @Override
    public BaseExpr build(SSExprParser.UnitContext unitContext)  {
        if(unitContext.consts().PI()!=null){
            return new NumberExpression(Tools.toBigDecimal(Math.PI));
        }else if(unitContext.consts().MIU()!=null){
            return new NumberExpression(Tools.toBigDecimal(1.45136d));
        }else if(unitContext.consts().EE()!=null){
            return new NumberExpression(Tools.toBigDecimal(Math.E));
        }else if(unitContext.consts().EB()!=null){
            return new NumberExpression(Tools.toBigDecimal(1.606695d));
        }else{
            return null;
        }
    }

    @Override
    public boolean support(SSExprParser.UnitContext unitContext) {
        return unitContext.consts()!=null;
    }
}
