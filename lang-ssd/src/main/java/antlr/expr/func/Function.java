package antlr.expr.func;

import antlr.CalException;
import antlr.model.data.ExprData;
import main.MyExprContext;

import java.util.List;

public interface Function {
    Object execute(List<ExprData<?>> dataList, MyExprContext ctx) ;
    String name();
}
