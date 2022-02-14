package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import main.MyExprContext;

public class ElseExpression extends BaseExpr {
    private ExpressionBlock expression;
    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        return expression.run(context);
    }
    public ExpressionBlock getExpression() {
        return expression;
    }
    public void setExpression(ExpressionBlock expression) {
        this.expression = expression;
    }
}
