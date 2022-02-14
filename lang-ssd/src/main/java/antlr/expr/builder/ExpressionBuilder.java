package antlr.expr.builder;

import antlr.CalException;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;
import antlr.expr.expr.BaseExpr;

public interface ExpressionBuilder {
    BaseExpr build(UnitContext unitContext) ;
    boolean support(UnitContext unitContext);
}
