package antlr.expr;

import antlr.CalException;
import antlr.expr.expr.Expr;
import antlr.model.Op;
import antlr.model.data.ExprData;
import antlr.model.data.NoneExpressionData;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import main.MyExprContext;

import java.util.List;

public class ExpressionCondition {
    private Expr left;
    private Op op;
    private Expr right;
    public ExpressionCondition(Expr left, Op op, Expr right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
    public boolean eval(MyExprContext context)  {
        ExprData<?> leftData=left.run(context);
        ExprData<?> rightData=right.run(context);
        Object leftObj=getData(leftData);
        Object rightObj=getData(rightData);
        return Tools.conditionEval(op, leftObj, rightObj);
    }

    private Object getData(ExprData<?> data)  {
        if(data instanceof ObjectExprData){
            ObjectExprData objData=(ObjectExprData)data;
            return objData.getData();
        }else if(data instanceof ObjectListExprData){
            ObjectListExprData exprData=(ObjectListExprData)data;
            List<?> list=exprData.getData();
            StringBuffer sb=new StringBuffer();
            for(Object obj:list){
                if(sb.length()>0){
                    sb.append(",");
                }
                sb.append(obj);
            }
            return sb.toString();
        }else if(data instanceof NoneExpressionData){
            return null;
        }else{
            throw new CalException("Unknow data : "+data);
        }
    }
    public Expr getLeft() {
        return left;
    }
    public Expr getRight() {
        return right;
    }
}
