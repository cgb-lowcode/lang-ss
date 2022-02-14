package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import main.MyExprContext;

import java.io.Serializable;

public interface Expr extends Serializable {
    ExprData<?> run(MyExprContext context) ;
}
