package antlr.expr.antlr4.impl;

import antlr.CalException;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.antlr4.SSTreeAbs;
import antlr.expr.expr.Expr;
import antlr.expr.expr.VariableArrayAssignExpression;
import antlr.expr.expr.VariableAssignExpression;
import antlr.expr.expr.VariableReAssignExpression;
import antlr.model.Operator;
import cal.SSExprParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class VarAssignImpl  extends SSTreeAbs {
    @Override
    public Expr expr()  {
        SSExprParser.VarAssignContext assignCtx = (SSExprParser.VarAssignContext)tree;
        if(assignCtx.augassign()!=null){
            if(assignCtx.leftHandSide().variable()!=null) {
                VariableReAssignExpression expr = new VariableReAssignExpression();
                expr.setExpr(assignCtx.getText());
                if (assignCtx.leftHandSide() != null && assignCtx.leftHandSide().variable() != null) {
                    expr.setVariable(assignCtx.leftHandSide().variable().Identifier().getText());
                }
                //自增赋值
                String op = assignCtx.augassign().getText();
                Operator ops = null;
                if (op.equals("+=")) {
                    ops = Operator.Add;
                } else if (op.equals("-=")) {
                    ops = Operator.Subtract;
                } else if (op.equals("*=")) {
                    ops = Operator.Multiply;
                } else if (op.equals("/=")) {
                    ops = Operator.Divide;
                } else if (op.equals("%=")) {
                    ops = Operator.Complementation;
                }
                expr.setOp(ops);
                expr.setExpression(ExpressionManager.parseExprComposite(assignCtx.exprComposite()));
                return expr;
            }else{
                throw new CalException("+=等赋值语句暂不支持数组类型！");
            }
        }else {
            //非数组赋值形式
            if(assignCtx.leftHandSide().variable()!=null) {
                VariableAssignExpression expr = new VariableAssignExpression();
                expr.setExpr(assignCtx.getText());
                expr.setVariable(assignCtx.leftHandSide().variable().Identifier().getText());
                expr.setExpression(ExpressionManager.parseExprComposite(assignCtx.exprComposite()));
                return expr;
            }else if(assignCtx.leftHandSide().arrayAccess()!=null){ //数组形式
                VariableArrayAssignExpression expr = new VariableArrayAssignExpression();
                expr.setExpr(assignCtx.getText());
                expr.setVariable(assignCtx.leftHandSide().arrayAccess().variable().Identifier().getText());
                expr.setIndexExpr(ExpressionManager.parseExpr(assignCtx.leftHandSide().arrayAccess().expr()));
                expr.setExpression(ExpressionManager.parseExprComposite(assignCtx.exprComposite()));
                return expr;
            }else{
                throw new CalException("赋值语句左侧必须是变量或数组索引！");
            }
        }
    }

    @Override
    public boolean support(ParseTree tree) {
        super.support(tree);
        return tree instanceof SSExprParser.VarAssignContext;
    }
}
