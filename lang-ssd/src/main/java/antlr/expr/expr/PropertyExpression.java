package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cal.SSExprParser;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import main.MyExprContext;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;

import java.util.List;

public class PropertyExpression extends BaseExpr{
    private String var;
    private String jsonpath;
    public PropertyExpression(String var,String jsonpath) {
        this.var = var;
        this.jsonpath = jsonpath;
    }

    @Override
    protected ExprData<?> compute(MyExprContext context) {
        Object obj=context.getVariable(var);
        Object result = null;
        JSONObject wrapperMap = new JSONObject();
        if(obj instanceof JSONArray){
            wrapperMap.set("ROOT",obj);
        }
        if(jsonpath.startsWith("ROOT")) {
            jsonpath = "$.ROOT" + jsonpath.substring(4,jsonpath.length());
            result = JsonPath.read(wrapperMap, jsonpath);
        }else{
            result = JsonPath.read(obj, "$." + jsonpath);
        }
        return new ObjectExprData(result);
    }
}
