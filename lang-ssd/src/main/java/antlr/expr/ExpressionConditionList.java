package antlr.expr;

import antlr.CalException;
import antlr.model.Join;
import main.MyExprContext;

import java.util.List;

public class ExpressionConditionList {
    private List<ExpressionCondition> conditions;
    private List<Join> joins;
    public ExpressionConditionList(List<ExpressionCondition> conditions,List<Join> joins) {
        this.conditions = conditions;
        this.joins = joins;
    }
    public boolean eval(MyExprContext context)  {
        if(conditions.size()==1){
            return conditions.get(0).eval(context);
        }
        for(int i=0;i<conditions.size();i++){
            ExpressionCondition condition=conditions.get(i);
            boolean result=condition.eval(context);
            Join join=null;
            if(i<joins.size()){
                join=joins.get(i);
            }
            if(join==null){
                return result;
            }else{
                if(join.equals(Join.and) && !result){
                    return false;
                }
                if(join.equals(Join.or) && result){
                    return true;
                }
            }
        }
        return true;
    }
    public List<ExpressionCondition> getConditions() {
        return conditions;
    }
}
