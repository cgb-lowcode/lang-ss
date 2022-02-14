package antlr.expr.builder.op;

import antlr.CalException;
import antlr.expr.Tools;
import antlr.expr.builder.AbstractAssertor;
import antlr.model.Op;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;

import java.math.BigDecimal;

public class EqualsAssertor extends AbstractAssertor {
    @Override
    public boolean eval(Object left, Object right)  {
        if(left == null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        if(left instanceof Number && right instanceof Number){
            BigDecimal b1= Tools.toBigDecimal(left);
            BigDecimal b2= Tools.toBigDecimal(right);
            return b1.compareTo(b2)==0;
        }else if(left instanceof Number){
            BigDecimal b1=Tools.toBigDecimal(left);
            BigDecimal b2=null;
            try{
                b2=Tools.toBigDecimal(right);
            }catch(Exception ex){}
            if(b2!=null){
                return b1.compareTo(b2)==0;
            }
        }else if(right instanceof Number){
            BigDecimal b1=Tools.toBigDecimal(right);
            BigDecimal b2=null;
            try{
                b2=Tools.toBigDecimal(left);
            }catch(Exception ex){}
            if(b2!=null){
                return b1.compareTo(b2)==0;
            }
        }else if(left instanceof String || right instanceof String){
            return StrUtil.equals(Convert.toStr(left), Convert.toStr(right),false);
        }else if(left instanceof Boolean || right instanceof Boolean){
            return Convert.toBool(left) && Convert.toBool(right);
        }
        right=buildObject(right);
        return left.equals(right);
    }

    @Override
    public Op getName() {
        return Op.Equals;
    }
}

