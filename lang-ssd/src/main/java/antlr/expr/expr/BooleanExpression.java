package antlr.expr.expr;

import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import main.MyExprContext;

public class BooleanExpression extends BaseExpr {
    private Boolean value;
    public BooleanExpression(Boolean value) {
        this.value=value;
    }
    @Override
    public ExprData<?> compute( MyExprContext context) {
        return new ObjectExprData(value);
    }
}