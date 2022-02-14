package antlr.expr.builder;

import java.util.List;

public abstract class AbstractAssertor implements Assertor{
    protected Object buildObject(Object obj){
        if(obj==null){
            return obj;
        }
        if(obj instanceof List){
            List<?> list=(List<?>)obj;
            if(list.size()==1){
                return list.get(0);
            }
        }
        return obj;
    }
}

