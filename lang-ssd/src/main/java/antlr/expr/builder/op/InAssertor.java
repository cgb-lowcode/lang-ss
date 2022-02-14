package antlr.expr.builder.op;

import antlr.expr.builder.Assertor;
import antlr.model.Op;

import java.util.List;

public class InAssertor implements Assertor {

    @Override
    public boolean eval(Object left, Object right) {
        if(left == null || right == null){
            return false;
        }
        if(right instanceof List){
            List<?> list=(List<?>)right;
            for(Object obj:list){
                if(left.equals(obj)){
                    return true;
                }
            }
            return false;
        }else if(right instanceof Object[]){
            Object[] objs=(Object[])right;
            for(Object obj:objs){
                if(left.equals(obj)){
                    return true;
                }
            }
            return false;
        }else if(right instanceof String){
            String[] array=right.toString().split(",");
            for(String str:array){
                if(left.equals(str)){
                    return true;
                }
            }
            return false;
        }
        return left.equals(right);
    }
    @Override
    public Op getName() {
        return Op.In;
    }
}
