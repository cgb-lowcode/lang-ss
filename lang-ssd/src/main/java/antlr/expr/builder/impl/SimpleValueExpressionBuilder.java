package antlr.expr.builder.impl;

import antlr.CalException;
import antlr.expr.Tools;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.expr.*;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;
import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.util.List;


//simpleValue : INTEGER|NUMBER|STRING|BOOLEAN|NULL;
public class SimpleValueExpressionBuilder implements ExpressionBuilder {
    @Override
    public BaseExpr build(UnitContext unitContext)  {
        if (unitContext.simpleValue().BOOLEAN() != null) {
            String text = unitContext.simpleValue().BOOLEAN().getText();
            return new BooleanExpression(Boolean.valueOf(text));
        } else if (unitContext.simpleValue().INTEGER() != null) {
            String text = unitContext.simpleValue().INTEGER().getText();
            return new IntegerExpression(Convert.toInt(text));
        } else if (unitContext.simpleValue().NUMBER() != null) {
            String text = unitContext.simpleValue().NUMBER().getText();
            return new NumberExpression(Tools.toBigDecimal(text));
        }else if(unitContext.simpleValue().NULL()!=null){
            return new NullExpression();
        }else if(unitContext.simpleValue().STRING()!=null){
            String text = unitContext.simpleValue().STRING().getText();
            if(text.startsWith("'''") || text.startsWith("\"\"\"")){
                //多行字符串
                text = text.substring(3, text.length() - 3);
            }else {
                //去掉前后引号
                text = text.substring(1, text.length() - 1);
            }
            return new StringExpression(text);
        }else if(unitContext.simpleValue().IMAG_NUMBER()!=null){
            //TODO:这里实现复数计算逻辑
        }
        throw new CalException("不支持的原子类型：" + unitContext.getText());

    }
    @Override
    public boolean support(UnitContext unitContext) {
        return unitContext.simpleValue()!=null;
    }


}
