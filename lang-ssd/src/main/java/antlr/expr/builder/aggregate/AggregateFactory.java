package antlr.expr.builder.aggregate;

import antlr.expr.builder.Assertor;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AggregateFactory {
    private static AggregateFactory instance = new AggregateFactory();
    private static Map<String,IAggregate> aggregates = new HashMap<String,IAggregate>();
    static{
        Set<Class<?>> buildClasses2 = ClassUtil.scanPackage("antlr.expr.builder.aggregate.impl");
        for(Class cls : buildClasses2){
            IAggregate a = (IAggregate) ReflectUtil.newInstance(cls);
            if(aggregates==null) aggregates = new HashMap<String,IAggregate>();
            aggregates.put(a.name(),a);
        }
    }
    private AggregateFactory(){

    }
    public static AggregateFactory instance(){
        if(instance == null){
            instance = new AggregateFactory();
        }
        return instance;
    }

    public IAggregate aggregate(String name){
        return aggregates.get(name);
    }

}
