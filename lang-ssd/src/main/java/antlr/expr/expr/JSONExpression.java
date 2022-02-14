package antlr.expr.expr;

import antlr.CalException;
import antlr.expr.ExpressionConditionList;
import antlr.expr.antlr4.ExpressionManager;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import antlr.model.data.ObjectListExprData;
import cal.SSExprParser;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import main.MyExprContext;

import java.util.ArrayList;
import java.util.List;

public class JSONExpression extends BaseExpr {
    private SSExprParser.JsonContext jsonContext; //jsonArray
    private SSExprParser.ObjContext objContext;
    private String json;
    public JSONExpression(SSExprParser.JsonContext jsonContext){
        this.jsonContext = jsonContext;
    }
    public JSONExpression(SSExprParser.ObjContext objContext){
        this.objContext = objContext;
    }
    public JSONExpression(String json){
        this.json = json;
    }
    @Override
    protected ExprData<?> compute(MyExprContext context) {
        try {
            if(StrUtil.isNotEmpty(this.json)){
                if(JSONUtil.isJsonArray(json)){
                    return new ObjectListExprData(JSONUtil.parseArray(this.json));
                }else{
                    return new ObjectExprData(JSONUtil.parseObj(this.json));
                }
            }else if(this.objContext!=null){
                return new ObjectExprData(pairs2obj(context,objContext.pair()));
            }else if(this.jsonContext.arr()!=null){
                JSONArray lists = new JSONArray();
                if(jsonContext.arr().obj()!=null && jsonContext.arr().obj().size()>0) {
                    List<SSExprParser.ObjContext> objs = jsonContext.arr().obj();
                    for (SSExprParser.ObjContext obj : objs) {
                        lists.add(pairs2obj(context,obj.pair()));
                    }
                }else{  //简单数组
                    List<SSExprParser.UnitContext> objs = jsonContext.arr().unit();
                    for (SSExprParser.UnitContext obj : objs) {
                        lists.add(ExpressionManager.buildExpression(obj).run(context).getData());
                    }
                    return new ObjectListExprData(lists);
                }
            }else if(this.jsonContext.obj()!=null){
                List<SSExprParser.PairContext> pairs = jsonContext.obj().pair();
                return new ObjectExprData(pairs2obj(context,pairs));
            }
            throw new CalException("无法处理的JSON操作");
        }catch(Exception ex){
            return null;
        }
    }

    private JSONObject pairs2obj(MyExprContext context,List<SSExprParser.PairContext> paris){
        JSONObject json = new JSONObject();
        for(SSExprParser.PairContext item : paris){
            String name = item.STRING().getText();
            name = name.substring(1,name.length()-1);
            Object v = ExpressionManager.parseExpr(item.expr()).run(context).getData();
            json.set(name, v);
        }
        return json;
    }


}