package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import main.MyExprContext;

public class VariableAssignExpression extends BaseExpr {
    private String variable;

    public Expr getExpression() {
        return expression;
    }

    public void setExpression(Expr expression) {
        this.expression = expression;
    }

    private Expr expression;
    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        ExprData<?> data=expression.run(context);
        Object obj=null;
        if(data instanceof ObjectExprData){
            ObjectExprData d=(ObjectExprData)data;
            obj=d.getData();
        }else if(data instanceof ObjectListExprData){
            ObjectListExprData d=(ObjectListExprData)data;
            obj=d.getData();
        }
        if(obj!=null){
            context.putVariable(variable, obj);
        }
        return null;
    }
    public String getVariable() {
        return variable;
    }
    public void setVariable(String variable) {
        this.variable = variable;
    }

}
