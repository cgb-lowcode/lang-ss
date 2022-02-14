package antlr.expr.expr;

import antlr.CalException;
import antlr.expr.ExpressionConditionList;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import main.MyExprContext;

import java.util.List;

public class IfExpression extends BaseExpr {
    private ExpressionConditionList conditionList;
    private ExpressionBlock expression;
    private List<ElseIfExpression> elseIfExpressions;
    private ElseExpression elseExpression;
    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        if(conditionList!=null){
            boolean result=conditionList.eval(context);
            if(result){
                return expression.run(context);
            }
        }
        if(elseIfExpressions!=null){
            for(ElseIfExpression elseIfExpr:elseIfExpressions){
                if(elseIfExpr.conditionsEval(context)){
                    return elseIfExpr.run(context);
                }
            }
        }
        if(elseExpression!=null){
            return elseExpression.run(context);
        }
        return new ObjectExprData(null);
    }
    public void setConditionList(ExpressionConditionList conditionList) {
        this.conditionList = conditionList;
    }
    public ExpressionConditionList getConditionList() {
        return conditionList;
    }
    public void setElseExpression(ElseExpression elseExpression) {
        this.elseExpression = elseExpression;
    }
    public void setElseIfExpressions(List<ElseIfExpression> elseIfExpressions) {
        this.elseIfExpressions = elseIfExpressions;
    }
    public ExpressionBlock getExpression() {
        return expression;
    }
    public void setExpression(ExpressionBlock expression) {
        this.expression = expression;
    }
    public ElseExpression getElseExpression() {
        return elseExpression;
    }
    public List<ElseIfExpression> getElseIfExpressions() {
        return elseIfExpressions;
    }
}

