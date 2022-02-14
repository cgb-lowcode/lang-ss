package antlr.expr.builder.op;

import antlr.expr.builder.Assertor;
import antlr.model.Op;

public class NotLikeAssertor implements Assertor {

    @Override
    public boolean eval(Object left, Object right) {
        if(left==null || right== null){
            return false;
        }
        return !LikeAssertor.like(left.toString(), right.toString());
    }
    @Override
    public Op getName() {
        return Op.NotLike;
    }
}

