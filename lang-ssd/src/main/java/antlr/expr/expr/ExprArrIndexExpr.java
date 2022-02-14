package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import main.MyExprContext;

import java.util.List;

public class ExprArrIndexExpr extends BaseExpr{
    private Expr variable;
    private Expr indexExpr;

    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        Object data=variable.run(context).getData();
        if(data instanceof List){
            List list = (List)data;
            ExprData<?> indexData = indexExpr.run(context);
            int idx = Convert.toInt(indexData.getData(), -1);
            if (list != null && idx >= 0 && idx < list.size()) {
                return new ObjectExprData(list.get(idx));
            }else{
                throw  new CalException("列表越界！！");
            }
        }else{
            throw  new CalException("属性运算符只能使用在JSON对象上！");
        }
    }

    public Expr getVariable() {
        return variable;
    }

    public void setVariable(Expr variable) {
        this.variable = variable;
    }

    public Expr getIndexExpr() {
        return indexExpr;
    }

    public void setIndexExpr(Expr indexExpr) {
        this.indexExpr = indexExpr;
    }
}
