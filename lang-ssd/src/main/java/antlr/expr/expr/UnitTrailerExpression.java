package antlr.expr.expr;

import antlr.CalException;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import main.MyExprContext;

import java.util.List;

public class UnitTrailerExpression extends BaseExpr {
    //变量名
    private String var;
    private boolean isProp =false;
    private String propName;
    private Expr indexExpr;
    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        Object obj=context.getVariable(var);
        if(isProp){
            if(obj instanceof JSONObject){
                JSONObject oo = (JSONObject)obj;
                return new ObjectExprData(oo.get(propName));
            }else{
                throw new CalException("变量.属性值只适合JSON类型！");
            }
        }else{
            ExprData data = indexExpr.run(context);
            if(obj instanceof List){
                List oo = (List)obj;
                if(data.getData() instanceof Integer && oo!=null){
                    Integer index = (Integer)data.getData();
                    if(index>=0&&index<oo.size()){
                        return new ObjectExprData(oo.get(index));
                    }
                }
                throw new CalException("List索引中只能使用整数或越界访问！");
            }else if(obj instanceof JSONArray){
                JSONArray oo = (JSONArray)obj;
                if(data.getData() instanceof Integer && oo!=null){
                    Integer index = (Integer)data.getData();
                    if(oo.size()>=index){
                        return new ObjectExprData(oo.get(index));
                    }
                }
                throw new CalException("JSONArray索引中只能使用整数或越界访问！");
            }else{
                throw new CalException("【】只能作用于数组或List类型！");
            }
        }
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public boolean isProp() {
        return isProp;
    }

    public void setProp(boolean prop) {
        isProp = prop;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public Expr getIndexExpr() {
        return indexExpr;
    }

    public void setIndexExpr(Expr indexExpr) {
        this.indexExpr = indexExpr;
    }
}
