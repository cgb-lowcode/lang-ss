package antlr.expr.expr;

import antlr.expr.expr.BaseExpr;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import main.MyExprContext;

public class StringExpression extends BaseExpr {
    private String text;
    public StringExpression(String text) {
        this.text=text;
    }

    @Override
    protected ExprData<?> compute(MyExprContext context) {
        return new ObjectExprData(text);
    }
}
