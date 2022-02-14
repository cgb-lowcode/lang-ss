package antlr.expr.expr;

import antlr.CalException;
import antlr.expr.ExpressionConditionList;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import main.MyExprContext;

public class TestExpression extends BaseExpr {
    private ExpressionConditionList conditionList;

    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        if(conditionList!=null){
            boolean result=conditionList.eval(context);
            return new ObjectExprData(result);
        }
        return new ObjectExprData(null);
    }
    public ExpressionConditionList getConditionList() {
        return conditionList;
    }
    public void setConditionList(ExpressionConditionList conditionList) {
        this.conditionList = conditionList;
    }


}
