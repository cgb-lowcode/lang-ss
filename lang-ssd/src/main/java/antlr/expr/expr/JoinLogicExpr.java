package antlr.expr.expr;
import antlr.CalException;
import antlr.model.Join;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import antlr.model.Operator;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import main.MyExprContext;
import antlr.model.data.ExprData;


import java.util.ArrayList;
import java.util.List;

public class JoinLogicExpr extends BaseExpr {
    private List<Join> joins;
    private List<Expr> expressions;

    public JoinLogicExpr(List<Join> joins, List<Expr> expressions) {
        this.joins = joins;
        this.expressions = expressions;
    }

    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        if(expressions.size()==1){
            return expressions.get(0).run(context);
        }
        List<Boolean> exprValueList=new ArrayList<Boolean>();
        boolean result = true;
        for(int i=0;i<expressions.size();i++){
            Expr expression=expressions.get(i);
            ExprData<?> data= expression.run(context);
            if(data instanceof ObjectExprData){
                ObjectExprData d=(ObjectExprData)data;
                Object s = d.getData();
                if(s instanceof Boolean){
                    exprValueList.add((Boolean)s);
                }else if(s instanceof String){
                    exprValueList.add(StrUtil.isNotBlank(Convert.toStr(s)));
                }else if(s instanceof Integer){
                    exprValueList.add((Integer)s != 0);
                }else{
                    throw new CalException("逻辑运算只支持布尔型，整数（非零）和字符串（非空）");
                }
            }else{
                throw new CalException("逻辑运算只支持简单值");
            }
        }
        //先检测表达式运算中，如果有null，则整个表达式为空
        if(exprValueList.stream().filter(s -> s==null).findFirst().isPresent()){
            return null;
        }
        String str=null;
        for(int i=0;i<exprValueList.size();i++){
            boolean data=exprValueList.get(i);
            if(i==0){
                result = data;
            }else {
                Join op = joins.get(i - 1);
                if(op == Join.and){
                    result = result && data;
                }else{
                    result = result || data;
                }
            }
        }
        return new ObjectExprData(result);
    }
}

