package antlr.expr.expr;

import antlr.CalException;
import antlr.expr.Tools;
import antlr.model.Operator;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import main.MyExprContext;

public class VariableReAssignExpression extends BaseExpr {
    private String variable;
    private Operator op;
    public Expr getExpression() {
        return expression;
    }

    public void setExpression(Expr expression) {
        this.expression = expression;
    }

    private Expr expression;
    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        Object paramObj=context.getVariable(variable);

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
            Object res = Tools.operatorObj(paramObj,obj,op);
            context.putVariable(variable, res);
        }
        return null;
    }
    public String getVariable() {
        return variable;
    }
    public void setVariable(String variable) {
        this.variable = variable;
    }

    public Operator getOp() {
        return op;
    }

    public void setOp(Operator op) {
        this.op = op;
    }
}
