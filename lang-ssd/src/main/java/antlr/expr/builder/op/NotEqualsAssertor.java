package antlr.expr.builder.op;

import antlr.expr.builder.AbstractAssertor;
import antlr.model.Op;

public class NotEqualsAssertor extends AbstractAssertor {

    @Override
    public boolean eval(Object left, Object right) {
        if(left == null && right==null){
            return false;
        }
        if(left==null || right==null){
            return true;
        }
        right=buildObject(right);
        return !left.equals(right);
    }

    @Override
    public Op getName() {
        return Op.NotEquals;
    }
}
