package main;

import antlr.expr.expr.ElCompute;

import java.util.HashMap;
import java.util.Map;

//表达式全局上下文，可以按需增加
public class MyExprContext {
    //保存局部变量
    private Map<String,Object> variableMap=new HashMap<String,Object>();

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    //外部传入的参数列表
    private Map<String,Object> parameters=new HashMap<String,Object>();
    public void putVariable(String key,Object value){
        variableMap.put(key, value);
    }
    public void resetVariableMap(){
        variableMap.clear();
    }
    public Object getVariable(String key){
        return variableMap.get(key);
    }

    /*
    * 统一计算形如：3*2+1+2的这种表达式
    * */
    public Object evalExpr(String expression){
        return new ElCompute().doCompute(expression);
    }
}
