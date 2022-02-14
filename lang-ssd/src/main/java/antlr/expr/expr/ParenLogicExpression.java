package antlr.expr.expr;

import antlr.model.Join;
import antlr.model.Operator;

import java.util.List;

public class ParenLogicExpression extends JoinLogicExpr {
    public ParenLogicExpression(List<Join> joins, List<Expr> expressions) {
        super(joins, expressions);
    }
}
