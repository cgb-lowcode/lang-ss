package antlr.expr.antlr4.impl;

import antlr.CalException;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.antlr4.SSTreeAbs;
import antlr.expr.expr.*;
import cal.SSExprParser;
import org.antlr.v4.runtime.tree.ParseTree;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;

import java.util.ArrayList;
import java.util.List;

public class IfExprImpl extends SSTreeAbs {
    @Override
    public boolean support(ParseTree tree) {
        super.support(tree);
        return tree instanceof IfExprContext;
    }
    @Override
    public Expr expr()  {
        IfExprContext ifExprContext=(IfExprContext)tree;
        return parseIfExprContext(ifExprContext);
    }

    private IfExpression parseIfExprContext(IfExprContext ifExprContext)  {
        IfExpression expr=new IfExpression();
        expr.setExpr(ifExprContext.getText());
        IfPartContext ifPartContext=ifExprContext.ifPart();
        List<TestContext> ifConditionContexts=ifPartContext.tests().test();
        List<JoinContext> joinContexts=ifPartContext.tests().join();
        expr.setConditionList(ExpressionManager.parseCondtionList(ifConditionContexts,joinContexts));
        ExpressionBlock blockExpr=ExpressionManager.parseBlock(ifPartContext.block());
        expr.setExpression(blockExpr);
        List<ElseIfPartContext> elseIfPartContexts=ifExprContext.elseIfPart();
        if(elseIfPartContexts!=null && elseIfPartContexts.size()>0){
            List<ElseIfExpression> elseIfExpressionList=new ArrayList<ElseIfExpression>();
            for(ElseIfPartContext elseIfContext:elseIfPartContexts){
                ifConditionContexts=elseIfContext.tests().test();
                joinContexts=elseIfContext.tests().join();
                ElseIfExpression elseIfExpr=new ElseIfExpression();
                elseIfExpr.setConditionList(ExpressionManager.parseCondtionList(ifConditionContexts,joinContexts));
                elseIfExpr.setExpression(ExpressionManager.parseBlock(elseIfContext.block()));
                elseIfExpressionList.add(elseIfExpr);
            }
            expr.setElseIfExpressions(elseIfExpressionList);
        }

        ElsePartContext elsePartContext=ifExprContext.elsePart();
        if(elsePartContext!=null){
            ElseExpression elseExpression=new ElseExpression();
            elseExpression.setExpression(ExpressionManager.parseBlock(elsePartContext.block()));
            expr.setElseExpression(elseExpression);
        }
        return expr;
    }
}
