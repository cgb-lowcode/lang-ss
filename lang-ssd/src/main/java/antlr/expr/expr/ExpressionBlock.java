package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import main.MyExprContext;

import java.util.List;

public class ExpressionBlock extends BaseExpr{
    private static final long serialVersionUID = -400528304334443664L;
    private List<Expr> expressionList;
    private Expr returnExpression;
    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        ExprData<?> data=null;
        if(expressionList!=null){
            for(Expr expr:expressionList){
                data=expr.run(context);
            }
        }
        if(returnExpression!=null){
            data=returnExpression.run(context);
        }
        return data;
    }
    public List<Expr> getExpressionList() {
        return expressionList;
    }
    public void setExpressionList(List<Expr> expressionList) {
        this.expressionList = expressionList;
    }
    public Expr getReturnExpression() {
        return returnExpression;
    }
    public void setReturnExpression(Expr returnExpression) {
        this.returnExpression = returnExpression;
    }
}

