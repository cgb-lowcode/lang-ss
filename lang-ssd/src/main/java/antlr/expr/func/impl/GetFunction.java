package antlr.expr.func.impl;

import antlr.CalException;
import antlr.expr.func.Function;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import main.MyExprContext;

import java.util.List;

public class GetFunction implements Function {
    /***
     * get函数可以有如下形式：
     *      get(JSON类型,属性名)
     *      get(数组类型，索引号）
     *      get(简单类型，为空时的默认值）
     * @param dataList
     * @param ctx
     * @return
     */
    @Override
    public Object execute(List<ExprData<?>> dataList, MyExprContext ctx)  {
        if(dataList!=null) {
            if (dataList.size() == 2) {
                Object arg1 = dataList.get(0).getData();
                Object arg2 = dataList.get(1).getData();
                if (arg1 instanceof JSONObject) {
                    JSONObject _json = (JSONObject) arg1;
                    return _json.get(Convert.toStr(arg2));
                } else if (arg1 instanceof JSONArray) {
                    JSONArray _json = (JSONArray) arg1;
                    return _json.get(Convert.toInt(arg2));
                } else if (arg1 instanceof String) {
                    return Convert.toStr(arg1, Convert.toStr(arg2));
                } else if (arg1 instanceof Integer) {
                    return Convert.toInt(arg1, Convert.toInt(arg2));
                } else {
                    return arg1;
                }
            }
        }
        throw new CalException("get 函数执行失败！");
    }

    @Override
    public String name() {
        return "get";
    }
}
