package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import cn.hutool.core.exceptions.ExceptionUtil;
import main.Cal;
import main.MyExprContext;

public abstract class BaseExpr implements Expr{
    protected String expr;

    @Override
    public ExprData<?> run(MyExprContext context)  {
        try{
            ExprData<?>  data=compute(context);
            return data;
        }catch (CalException ex){
            throw new CalException("ERROR:" + ExceptionUtil.getMessage(ex));
        }
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }
    public String getExpr() {
        return expr;
    }

    protected abstract ExprData<?> compute( MyExprContext context) ;
}
