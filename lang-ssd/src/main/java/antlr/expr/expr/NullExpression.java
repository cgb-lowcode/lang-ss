package antlr.expr.expr;

import antlr.model.data.ExprData;
import antlr.model.data.NoneExpressionData;
import main.MyExprContext;

public class NullExpression extends BaseExpr {
    @Override
    public ExprData<?> compute(MyExprContext context) {
        return new NoneExpressionData();
    }
}
