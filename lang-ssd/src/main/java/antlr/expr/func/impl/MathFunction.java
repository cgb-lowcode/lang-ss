package antlr.expr.func.impl;

import antlr.expr.func.Function;
import antlr.model.data.ExprData;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ReflectUtil;
import main.MyExprContext;

import java.lang.reflect.Method;
import java.util.List;

public class MathFunction implements Function {
    @Override
    public Object execute(List<ExprData<?>> dataList, MyExprContext ctx) {
        //先解析出函数名，刑辱：math("sin",3.14/6);
        if(dataList!=null){
            if(dataList.size() >= 1){
                String funcName = Convert.toStr(dataList.get(0).getData());
                Method m = ReflectUtil.getMethodByName(Math.class,funcName);
                if(dataList.size() == 1) {
                    return ReflectUtil.invokeStatic(m);
                }else{
                    List<ExprData<?>> paramsList = CollUtil.sub(dataList,1,dataList.size());
                    Object[] paramsArr = new Object[paramsList.size()];
                    for(int i=0;i<paramsList.size();i++){
                        paramsArr[i] = paramsList.get(i).getData();
                    }
                    return ReflectUtil.invokeStatic(m,paramsArr);
                }
            }
        }
        return null;
    }

    @Override
    public String name() {
        return "math";
    }
}
