package antlr.expr.builder.aggregate;

import antlr.CalException;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.Expr;
import cal.SSExprParser;
import main.MyExprContext;

public interface IAggregate {
    public BaseExpr expr(MyExprContext context,SSExprParser.DatasetContext ctx) ;
    public String name();
}
