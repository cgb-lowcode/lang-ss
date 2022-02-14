package antlr.expr.func.impl;

import antlr.CalException;
import antlr.expr.func.Function;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import main.MyExprContext;

import java.util.List;

public class JsonPathFunction implements Function {
    @Override
    public Object execute(List<ExprData<?>> dataList, MyExprContext ctx)  {
        if(dataList!=null && (dataList.size()==2 || dataList.size()==3)) {
            Object v = dataList.get(0).getData();
            if (dataList.size() == 2) {  //读取
                if (v instanceof JSONObject || v instanceof JSONArray) {
                    Object ret = null;
                    try{
                        ret = JsonPath.read(v, Convert.toStr(dataList.get(1).getData()));
                    }catch(Exception ex){
                        CalException.log("error", ExceptionUtil.getMessage(ex));
                    }
                    return new ObjectExprData(ret);
                } else {
                    throw new CalException("json操作只能作用于JSON对象或数组");
                }
            }/*else if(dataList.size()==3){ //赋值
            if (v instanceof JSONObject || v instanceof JSONArray) {
                Object newVal = dataList.get(2).getData();
                //JSON的赋值语句
                Object ret = JsonPath.read(v, Convert.toStr(dataList.get(1).getData()));
                return new ObjectExprData(ret);
            } else {
                throw new CalException("json操作只能作用于JSON对象或数组");
            }
        }*/
            throw new CalException("json操作只能作用于JSON对象或数组");
        }else{
            throw new CalException("jsonpath必须是两个参数！");
        }
    }

    @Override
    public String name() {
        return "jsonpath";
    }
}
