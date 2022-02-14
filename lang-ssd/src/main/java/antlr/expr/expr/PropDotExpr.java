package antlr.expr.expr;

import antlr.CalException;
import antlr.expr.antlr4.ExpressionManager;
import antlr.model.data.ExprData;
import antlr.model.data.ObjectExprData;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import main.MyExprContext;

public class PropDotExpr extends BaseExpr{
    private Expr expression;
    private String propName;

    @Override
    protected ExprData<?> compute(MyExprContext context)  {
        ExprData<?> data=expression.run(context);
        Object obj = data.getData();

        JSONObject wrapperMap = new JSONObject();
        if(obj instanceof JSONObject){
            JSONObject _json = (JSONObject)obj;
            return new ObjectExprData(_json.get(propName));
        }else{
            throw  new CalException("属性运算符只能使用在JSON对象上！");
        }
    }

    public Expr getExpression() {
        return expression;
    }

    public void setExpression(Expr expression) {
        this.expression = expression;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }
}
