package antlr.expr.builder.op;

import antlr.CalException;
import antlr.expr.Tools;
import antlr.expr.builder.AbstractAssertor;
import antlr.model.Op;
import cn.hutool.core.util.StrUtil;

import java.math.BigDecimal;

public class LessThenAssertor  extends AbstractAssertor {

    @Override
    public boolean eval(Object left, Object right)  {
        if(left==null || right==null){
            return false;
        }
        if(StrUtil.isBlank(left.toString()) || StrUtil.isBlank(right.toString())){
            return false;
        }
        BigDecimal leftObj= Tools.toBigDecimal(left);
        right=buildObject(right);
        BigDecimal rightObj=Tools.toBigDecimal(right);
        return leftObj.compareTo(rightObj)==-1;
    }

    @Override
    public Op getName() {
        return Op.LessThen;
    }
}

