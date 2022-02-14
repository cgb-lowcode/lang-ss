package antlr.expr.expr;

import antlr.CalException;
import antlr.expr.Tools;
import antlr.expr.func.Function;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import main.MyExprContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FunctionExpression extends BaseExpr{
    private String name;
    private List<Expr> expressions;

    @Override
    public ExprData<?> compute(MyExprContext context)  {
        Function targetFunction= Tools.functions.get(name);
        if(targetFunction==null){
            throw new CalException("Function ["+name+"] not exist.");
        }
        List<ExprData<?>> dataList=new ArrayList<ExprData<?>>();
        if(expressions!=null){
            for(Expr expr:expressions){
                ExprData<?> data=expr.run(context);
                dataList.add(data);
            }
        }
        Object obj=targetFunction.execute(dataList, context);
        if(obj instanceof List){
            return new ObjectListExprData((List<?>)obj);
        }
        return new ObjectExprData(obj);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setExpressions(List<Expr> expressions) {
        this.expressions = expressions;
    }
    public List<Expr> getExpressions() {
        return expressions;
    }
}
