package antlr.expr.func.impl;

import antlr.CalException;
import antlr.expr.func.Function;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ReUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import main.MyExprContext;

import java.util.List;
import java.util.regex.Pattern;

public class ReFunction implements Function {
    @Override
    public Object execute(List<ExprData<?>> dataList, MyExprContext ctx)  {
        if(dataList!=null && dataList.size()>0) {
            Object v = dataList.get(0).getData();
            String str = "";
            if(v instanceof  String){
                str = Convert.toStr(v);
            }
            if(dataList.size() == 2){
                return ReUtil.findAllGroup0(Pattern.compile(Convert.toStr(dataList.get(1).getData())),str);
            }else if(dataList.size() == 3){
                Object arg3 = dataList.get(2).getData();
                 if(arg3 instanceof String){
                    return ReUtil.replaceAll(
                            str,
                            Convert.toStr(dataList.get(1).getData()),
                            Convert.toStr(arg3)
                    );
                }else{
                    throw new CalException("第三个桉树必须是替换的字符串！");
                }
            }
        }
        throw new CalException("正则解析必须是两个或三个参数，且第一个参数为字符串类型！");
    }

    @Override
    public String name() {
        return "re";
    }
}