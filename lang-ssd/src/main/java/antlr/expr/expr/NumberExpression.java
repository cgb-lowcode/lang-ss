package antlr.expr.expr;

import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import main.MyExprContext;

import java.math.BigDecimal;

public class NumberExpression extends BaseExpr {
    private BigDecimal value;
    public NumberExpression(BigDecimal value) {
        this.value=value;
    }
    @Override
    public ExprData<?> compute(MyExprContext context) {
        return new ObjectExprData(value.floatValue());
    }
}
