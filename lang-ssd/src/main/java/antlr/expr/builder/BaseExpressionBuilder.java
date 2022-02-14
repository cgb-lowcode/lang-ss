package antlr.expr.builder;

import antlr.CalException;
import antlr.expr.Tools;
import antlr.expr.expr.*;
import antlr.model.Op;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public abstract class BaseExpressionBuilder implements ExpressionBuilder{
//    //simpleValue : INTEGER|NUMBER|STRING|BOOLEAN|NULL;
//    protected Expr parseSimpleValueContext(SimpleValueContext valueContext) {
//        if(valueContext.BOOLEAN()!=null){
//            return new BooleanExpression(Boolean.valueOf(valueContext.getText()));
//        }else if(valueContext.INTEGER()!=null){
//            return new IntegerExpression(Integer.valueOf(valueContext.INTEGER().getText()));
//        }else if(valueContext.STRING()!=null){
//            String text=valueContext.STRING().getText();
//            text=text.substring(1,text.length()-1);
//            return new StringExpression(text);
//        }else if(valueContext.NUMBER()!=null){
//            return new NumberExpression(Tools.toBigDecimal(valueContext.NUMBER().getText()));
//        }else if(valueContext.NULL()!=null){
//            return new NullExpression();
//        }else if(valueContext.IMAG_NUMBER()!=null){
//            //TODO:这里实现复数计算逻辑
//        }else if(valueContext.obj()!=null){
//            String jsonStr = valueContext.obj().getText();
//            return null;
//        }else if(valueContext.arr()!=null){
//            String jsonStr = valueContext.arr().getText();
//            return null;
//        }
//        throw new CalException("Unknow simple value context "+valueContext);
//    }

    private Op parseOp(TerminalNode opNode)  {
        if(opNode.getText().equals(">")){
            return Op.GreatThen;
        }
        if(opNode.getText().equals("<")){
            return Op.LessThen;
        }
        if(opNode.getText().equals(">=")){
            return Op.EqualsGreatThen;
        }
        if(opNode.getText().equals("<=")){
            return Op.EqualsLessThen;
        }
        if(opNode.getText().equals("==")){
            return Op.Equals;
        }
        if(opNode.getText().equals("!=")){
            return Op.NotEquals;
        }
        throw new CalException("Unknow operator :" +opNode);
    }
}

