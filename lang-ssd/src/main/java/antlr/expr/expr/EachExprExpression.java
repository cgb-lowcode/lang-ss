package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import main.MyExprContext;

import java.util.List;

public class EachExprExpression extends BaseExpr {
    private String nameItem;
    //List表达式
    private Expr items;
    private ExpressionBlock expression;
    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        ExprData data = items.run(context);
        if(data.getData() instanceof List){
            List resultList = (List)data.getData();
            for(Object v : resultList){
                if(StrUtil.isNotEmpty(nameItem)){
                    context.putVariable(nameItem,v);
                }
                expression.run(context);
            }
            return new ObjectExprData(null);
        }else if(data.getData() instanceof JSONObject){
            JSONObject resultList = (JSONObject)data.getData();
            for(String key : resultList.keySet()){
                if(StrUtil.isNotEmpty(nameItem)){
                    context.putVariable(nameItem,resultList.get(key));
                }
                expression.run(context);
            }
        }else if(data.getData() instanceof JSONArray){
            JSONArray resultList = (JSONArray)data.getData();
            for(Object v : resultList){
                if(StrUtil.isNotEmpty(nameItem)){
                    context.putVariable(nameItem,v);
                }
                expression.run(context);
            }
            return new ObjectExprData(null);
        }
        throw new CalException("each只能用在list类型的遍历上！");
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Expr getItems() {
        return items;
    }

    public void setItems(Expr items) {
        this.items = items;
    }

    public ExpressionBlock getExpression() {
        return expression;
    }

    public void setExpression(ExpressionBlock expression) {
        this.expression = expression;
    }
}
