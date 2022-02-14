package antlr.expr.antlr4;

import org.antlr.v4.runtime.tree.ParseTree;

public abstract  class SSTreeAbs implements SSTree{
    protected ParseTree tree;

    @Override
    public boolean support(ParseTree tree) {
        this.tree = tree;
        return false;
    }
}
