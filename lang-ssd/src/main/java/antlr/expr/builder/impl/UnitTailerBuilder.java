package antlr.expr.builder.impl;

import antlr.expr.Tools;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.Expr;
import antlr.expr.expr.NumberExpression;
import antlr.expr.expr.UnitTrailerExpression;
import cal.SSExprParser;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;

import java.util.List;


public class UnitTailerBuilder  implements ExpressionBuilder {
    @Override
    public BaseExpr build(UnitContext unitContext) {
//        UnitTrailerExpression returnExpr = new UnitTrailerExpression();
//
//        Unit_trailerContext tailer = unitContext.unit_trailer();
//
//        //被索引对象
//        VariableContext var = unitContext.variable();
//        String identifier = var.Identifier().getText();
//        returnExpr.setVar(identifier);
//
//        //后面索引部分
//        List<TrailerContext> tailerList =  tailer.trailer();
//        TrailerContext first = tailerList.get(0);
//        if(first instanceof  TailerIndexContext){
//            //TODO:这里只是实现了一维
//            TailerIndexContext _indexUnit = (TailerIndexContext)first;
//            returnExpr.setProp(false);
//            Expr baseExpr= ExpressionManager.buildExpression(_indexUnit.unit());
//            returnExpr.setIndexExpr(baseExpr);
//        }else{
//            TailerPropContext _indexUnit = (TailerPropContext)first;
//            //属性访问方式
//            returnExpr.setProp(true);
//            returnExpr.setPropName(_indexUnit.variable().Identifier().getText());
//        }
//        return returnExpr;
        return null;
    }

    @Override
    public boolean support(SSExprParser.UnitContext unitContext) {

        //return unitContext.unit_trailer()!=null;
        return false;
    }
}
