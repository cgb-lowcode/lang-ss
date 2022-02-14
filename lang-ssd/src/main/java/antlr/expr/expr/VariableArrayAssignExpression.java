package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import cn.hutool.core.convert.Convert;
import main.MyExprContext;

import java.util.List;

public class VariableArrayAssignExpression extends BaseExpr {
    private String variable;
    private Expr indexExpr;
    public Expr getExpression() {
        return expression;
    }

    public void setExpression(Expr expression) {
        this.expression = expression;
    }

    private Expr expression;
    public Expr getIndexExpr() {
        return indexExpr;
    }

    public void setIndexExpr(Expr indexExpr) {
        this.indexExpr = indexExpr;
    }

    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        //数组
        ExprData<?> fuzhi=expression.run(context);
        if(context.getVariable(variable) instanceof ObjectListExprData) {
            List obj = (List) context.getVariable(variable);
            //索引计算
            ExprData<?> indexData = indexExpr.run(context);
            ObjectListExprData d = (ObjectListExprData) fuzhi;
            Object fuzhi_obj = (List) d.getData();
            int idx = Convert.toInt(indexData.getData(), -1);
            if (obj != null && idx >= 0 && idx < obj.size()) {
                obj.set(idx, fuzhi_obj);
            }
            if (obj != null) {
                context.putVariable(variable, obj);
            }
            return null;
        }else{
            throw new CalException("数组赋值左边只能是数组类型！");
        }
    }
    public String getVariable() {
        return variable;
    }
    public void setVariable(String variable) {
        this.variable = variable;
    }

}
