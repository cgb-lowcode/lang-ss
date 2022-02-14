package antlr.expr.expr;

import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import main.MyExprContext;

public class IntegerExpression extends BaseExpr {
    private Integer value;
    public IntegerExpression(Integer value) {
        this.value=value;
    }
    @Override
    protected ExprData<?> compute(MyExprContext context) {
        return new ObjectExprData(value);
    }
}
