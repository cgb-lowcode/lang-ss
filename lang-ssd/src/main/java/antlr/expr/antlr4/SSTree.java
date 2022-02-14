package antlr.expr.antlr4;

import antlr.CalException;
import antlr.expr.expr.Expr;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;

public interface SSTree{
    public Expr expr() ;
    public boolean support(ParseTree tree);
}
