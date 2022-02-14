package antlr.expr.expr;

import antlr.model.data.ExprData;
import antlr.model.data.NoneExpressionData;
import antlr.model.data.ObjectListExprData;
import main.MyExprContext;

import java.util.List;

public class ListExpr extends BaseExpr {
    private List<Object> lists;
    public ListExpr(List<Object> lists){
        this.lists = lists;
    }
    @Override
    public ExprData<?> compute(MyExprContext context) {
        return new ObjectListExprData(lists);
    }
}