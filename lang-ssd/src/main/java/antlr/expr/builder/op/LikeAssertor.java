package antlr.expr.builder.op;

import antlr.expr.builder.Assertor;
import antlr.model.Op;
import cn.hutool.core.util.StrUtil;

public class LikeAssertor implements Assertor {

    @Override
    public boolean eval(Object left, Object right) {
        if(left==null || right== null){
            return false;
        }
        if(left.equals(right)){
            return true;
        }
        return like(left.toString(),right.toString());
    }

    public static boolean like(String left,String right) {
        if(StrUtil.startWith(right, "%") && StrUtil.endWith(right, "%")) {
            right = StrUtil.sub(right, 0,right.length()-1);
            right = StrUtil.sub(right, 1,right.length());
            return left.toString().indexOf(right.toString())>-1;
        }else if(StrUtil.startWith(right, "%")) {
            right = StrUtil.sub(right, 1,right.length());
            return StrUtil.endWith(left, right);
        }else if(StrUtil.endWith(right, "%")) {
            right = StrUtil.sub(right, 0,right.length()-1);
            return StrUtil.startWith(left, right);
        }else {
            return left.toString().indexOf(right.toString())>-1;
        }
    }
    @Override
    public Op getName() {
        return Op.Like;
    }
}

