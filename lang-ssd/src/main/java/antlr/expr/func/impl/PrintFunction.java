package antlr.expr.func.impl;

import antlr.CalException;
import antlr.expr.func.Function;
import antlr.model.data.ExprData;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.TypeUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import main.MyExprContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrintFunction implements Function {
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
            List<String> result = new ArrayList<>();
            for(ExprData data : dataList){
                if(data.getData()!=null){
                    if(data.getData() instanceof String){
                        result.add(Convert.toStr(data.getData()));
                    }else if(data.getData() instanceof Integer || data.getData() instanceof BigDecimal){
                        result.add(Convert.toStr(data.getData()));
                    }else if(data.getData() instanceof Boolean){
                        result.add(Convert.toStr(data.getData()));
                    }else if(data.getData() instanceof Double || data.getData() instanceof Float){
                        result.add(Convert.toStr(data.getData()));
                    }else{
                        result.add(JSONUtil.toJsonStr(data.getData()));
                    }
                }else{
                    result.add("null");
                }
            }
            String sb = CollUtil.join(result," , ");
            CalException.log("#####print:",sb);
            return null;
        }
        throw new CalException("get 函数执行失败！");
    }

    @Override
    public String name() {
        return "print";
    }
}
