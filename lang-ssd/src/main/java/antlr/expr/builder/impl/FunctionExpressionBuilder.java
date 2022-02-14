package antlr.expr.builder.impl;

import java.util.ArrayList;
import java.util.List;

import antlr.CalException;
import antlr.expr.ParseExprUtil;
import antlr.expr.builder.BaseExpressionBuilder;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.Expr;
import antlr.expr.expr.FunctionExpression;
import cal.SSExprParser.*;

import static antlr.expr.antlr4.ExpressionManager.parseExpr;
import static antlr.expr.antlr4.ExpressionManager.parseItemContext;

public class FunctionExpressionBuilder extends BaseExpressionBuilder {
    @Override
    public BaseExpr build(UnitContext unitContext)  {
        FunctionContext ctx=unitContext.function();
        FunctionExpression expr=new FunctionExpression();
        expr.setExpr(ctx.getText());
        expr.setName(ctx.Identifier().getText());
        FunctionParameterContext functionParameterContext=ctx.functionParameter();
        if(functionParameterContext!=null){
            List<Expr> exprList=new ArrayList<Expr>();
            List<ExprContext> itemContexts=functionParameterContext.expr();
            if(itemContexts!=null){
                for(int i=0;i<itemContexts.size();i++){
                    ExprContext itemContext=itemContexts.get(i);
                    Expr baseExpr= parseExpr(itemContext);
                    exprList.add(baseExpr);
                }
            }
            expr.setExpressions(exprList);
        }
        return expr;
    }

    @Override
    public boolean support(UnitContext unitContext) {
        return unitContext.function()!=null;
    }
}