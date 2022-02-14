package antlr.expr.antlr4.impl;

import antlr.CalException;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.antlr4.SSTreeAbs;
import antlr.expr.expr.Expr;
import antlr.expr.expr.VariableAssignExpression;
import cal.SSExprParser;
import org.antlr.v4.runtime.tree.ParseTree;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;

public class ReturnExprImpl extends SSTreeAbs {
    @Override
    public Expr expr()  {
        ReturnExprContext returnCtx = (ReturnExprContext)tree;
        return ExpressionManager.parseExprComposite(returnCtx.exprComposite());
    }

    @Override
    public boolean support(ParseTree tree) {
        super.support(tree);
        return tree instanceof ReturnExprContext;
    }
}
