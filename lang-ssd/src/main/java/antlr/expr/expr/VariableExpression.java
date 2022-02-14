package antlr.expr.expr;

import antlr.CalException;
import antlr.expr.DataUtil;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import main.MyExprContext;

import java.math.BigDecimal;
import java.util.List;

public class VariableExpression extends BaseExpr{
    private String text;
    private String op;
    public VariableExpression(String text) {
        this.text=text;
    }
    public VariableExpression(String text,String op) {
        this.text=text;
        this.op = op;
    }
    @Override
    protected ExprData<?> compute(MyExprContext context) {
        if(StrUtil.isEmpty(op)) {
            //如果是指标，直接返回该指标序列数据
            if (DataUtil.isGjkCode(text)) {
                List list = DataUtil.getDataByGjkCode(text);
                return new ObjectListExprData(list);
            } else {
                if (context != null) {
                    Object obj = context.getVariable(text);
                    return new ObjectExprData(obj);
                }
            }
        }else{
            Object obj = null;
            if (context != null) {
                obj = context.getVariable(text);

            }
            obj = calObj(obj,op);
            return new ObjectExprData(obj);
        }
        return null;
    }

    private Object calObj(Object obj,String op){
        Object result = null;
        if(op.equals("++") || op.equals("--")){
            if(obj instanceof Integer || obj instanceof Long){
                if(op.equals("++")) {
                    return Convert.toInt(obj) + 1;
                }else{
                    return Convert.toInt(obj) - 1;
                }
            }else if(obj instanceof BigDecimal){
                BigDecimal bd = (BigDecimal)obj;
                if(op.equals("++")) {
                    return bd.add(new BigDecimal(1));
                }else{
                    return bd.min(new BigDecimal(1));
                }
            }else{
                throw new CalException("++/--只能用于数字类型！");
            }
        }else if(op.equals("not") || op.equals("!")){
            if(obj instanceof Boolean){
                return !Convert.toBool(obj);
            }else{
                throw new CalException("!和not只能用于布尔类型！");
            }
        }
        return result;
    }


}
