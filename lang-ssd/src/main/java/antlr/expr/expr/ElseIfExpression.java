package antlr.expr.expr;

import antlr.CalException;
import antlr.expr.ExpressionConditionList;
import antlr.model.data.ExprData;
import main.MyExprContext;

public class ElseIfExpression extends BaseExpr {
    private ExpressionConditionList conditionList;

    private ExpressionBlock expression;
    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        return expression.run(context);
    }
    public boolean conditionsEval(MyExprContext context)  {
        return conditionList.eval(context);
    }
    public void setConditionList(ExpressionConditionList conditionList) {
        this.conditionList = conditionList;
    }
    public ExpressionBlock getExpression() {
        return expression;
    }
    public void setExpression(ExpressionBlock expression) {
        this.expression = expression;
    }
}

