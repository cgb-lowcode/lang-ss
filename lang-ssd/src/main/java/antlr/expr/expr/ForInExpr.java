package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import main.MyExprContext;

import java.util.List;

public class ForInExpr extends BaseExpr {
    private String nameIndex,nameItem;
    private Expr items;
    private ExpressionBlock expression;
    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        //最后一个肯定是list类型
        ExprData data = items.run(context);
        if(data.getData() instanceof List){
            List resultList = (List)data.getData();
            int index = 0;
            for(Object v : resultList){
                if(StrUtil.isNotEmpty(nameIndex)){
                    context.putVariable(nameIndex,index);
                }
                if(StrUtil.isNotEmpty(nameItem)){
                    context.putVariable(nameItem,v);
                }
                expression.run(context);
                ++index;
            }
            return new ObjectExprData(null);
        }else if(data.getData() instanceof JSONObject){
            JSONObject resultList = (JSONObject)data.getData();
            for(String key : resultList.keySet()){
                if(StrUtil.isNotEmpty(nameIndex)){
                    context.putVariable(nameIndex,key);
                }
                if(StrUtil.isNotEmpty(nameItem)){
                    context.putVariable(nameItem,resultList.get(key));
                }
                expression.run(context);
            }
        }else if(data.getData() instanceof JSONArray){
            JSONArray resultList = (JSONArray)data.getData();
            int index = 0;
            for(Object v : resultList){
                if(StrUtil.isNotEmpty(nameIndex)){
                    context.putVariable(nameIndex,index);
                }
                if(StrUtil.isNotEmpty(nameItem)){
                    context.putVariable(nameItem,v);
                }
                expression.run(context);
                ++index;
            }
            return new ObjectExprData(null);
        }
        throw new CalException("必须是可迭代类型的迭代才能使用forin语句！");
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

    public String getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(String nameIndex) {
        this.nameIndex = nameIndex;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public void setExpression(ExpressionBlock expression) {
        this.expression = expression;
    }
}
