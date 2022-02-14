package antlr.expr.expr;

import antlr.model.Operator;

import java.util.List;

//| '(' item ')'                  # parens
public class ParenExpression extends JoinExpr {
    public ParenExpression(List<Operator> operators, List<Expr> expressions) {
        super(operators, expressions);
    }
}
