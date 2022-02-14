package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import antlr.model.Operator;
import cn.hutool.core.collection.CollUtil;
import main.MyExprContext;
import antlr.model.data.ExprData;


import java.util.ArrayList;
import java.util.List;

public class JoinExpr extends BaseExpr {
    private List<Operator> operators;
    private List<Expr> expressions;

    public JoinExpr(List<Operator> operators, List<Expr> expressions) {
        this.operators = operators;
        this.expressions = expressions;
    }

    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        if(expressions.size()==1){
            return expressions.get(0).run(context);
        }
        List<Object> exprValueList=new ArrayList<Object>();
        for(int i=0;i<expressions.size();i++){
            Expr expression=expressions.get(i);
            ExprData<?> data= expression.run(context);
            //计算每个表达式的值
            if(data instanceof ObjectExprData){
                ObjectExprData d=(ObjectExprData)data;
                exprValueList.add(d.getData());
            }else if(data instanceof ObjectListExprData){
                ObjectListExprData d=(ObjectListExprData)data;
                exprValueList.add(d.getData());
            }
        }
        //先检测表达式运算中，如果有null，则整个表达式为空,List有NUll会产生null异常，所以不能用stream
        if(CollUtil.hasNull(exprValueList)){
            return null;
        }
//        if(exprValueList.stream().filter(s -> s==null).findFirst().isPresent()){
//            return null;
//        }
        String str=null;
        for(int i=0;i<exprValueList.size();i++){
            Object data=exprValueList.get(i);
            if(str==null){
                if(data instanceof String){
                    str="\""+data+"\"";
                }else{
                    str=""+data+"";
                }
            }else{
                Operator op=operators.get(i-1);
                if(data instanceof String){
                    str+=""+op+"\""+data+"\"";
                }else{
                    str+=""+op+""+data+"";
                }
            }
        }
        Object obj=context.evalExpr(str);
        return new ObjectExprData(obj);
    }
}
