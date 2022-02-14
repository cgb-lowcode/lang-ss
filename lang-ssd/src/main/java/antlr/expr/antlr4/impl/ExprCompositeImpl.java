package antlr.expr.antlr4.impl;

import antlr.CalException;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.antlr4.SSTree;
import antlr.expr.antlr4.SSTreeAbs;
import antlr.expr.expr.ElseExpression;
import antlr.expr.expr.Expr;
import antlr.expr.expr.IfExpression;
import antlr.expr.expr.ParenExpression;
import antlr.model.Operator;
import org.antlr.v4.runtime.tree.ParseTree;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;

import java.util.ArrayList;
import java.util.List;

public class ExprCompositeImpl extends SSTreeAbs {

    @Override
    public boolean support(ParseTree tree) {
        super.support(tree);
        return tree instanceof ExprCompositeContext;
    }

    @Override
    public Expr expr()  {
        ExprCompositeContext exprCompositeContext = (ExprCompositeContext)tree;
        return ExpressionManager.parseExprComposite(exprCompositeContext);
    }


}
