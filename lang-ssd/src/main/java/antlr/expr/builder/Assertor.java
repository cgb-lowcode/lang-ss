package antlr.expr.builder;

import antlr.CalException;
import antlr.model.Op;

public interface Assertor {
    boolean eval(Object left,Object right) ;
    Op getName();
}
