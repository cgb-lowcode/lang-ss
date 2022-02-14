package antlr.expr;

import antlr.CalException;
import antlr.expr.expr.Expr;
import antlr.expr.listens.ExpressionErrorListener;
import antlr.expr.listens.PurviewListener;
import antlr.model.ErrorInfo;
import cal.SSExprLexer;
import cal.SSExprParser;
import main.MyCalVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

public class ParseExprUtil {
    private static MyCalVisitor visitor;
    public static Expr parseExpression(String text)  {
        CodePointCharStream antlrInputStream=CharStreams.fromString(text);
        SSExprLexer lexer=new SSExprLexer(antlrInputStream);
        CommonTokenStream tokenStream=new CommonTokenStream(lexer);
        SSExprParser parser=new SSExprParser(tokenStream);
        ExpressionErrorListener errorListener=new ExpressionErrorListener();
        parser.addErrorListener(errorListener);
        visitor=new MyCalVisitor();
        Expr expression=visitor.visitStat(parser.stat());
        String error=errorListener.getErrorMessage();
        if(error!=null){
            throw new CalException("Expression parse error:"+error);
        }
        return expression;
    }

    public static void walkTree(String text)  {
        CodePointCharStream antlrInputStream=CharStreams.fromString(text);
        SSExprLexer lexer=new SSExprLexer(antlrInputStream);
        CommonTokenStream tokenStream=new CommonTokenStream(lexer);
        SSExprParser parser=new SSExprParser(tokenStream);
        ExpressionErrorListener errorListener=new ExpressionErrorListener();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.stat();
        System.out.println(tree.toStringTree());
        ParseTreeWalker walker = new ParseTreeWalker();
        PurviewListener purviewListener = new PurviewListener();
        walker.walk(purviewListener,tree);
    }

    public static List<ErrorInfo> validation(String text){
        try{
            CodePointCharStream antlrInputStream=CharStreams.fromString(text);
            ExpressionErrorListener errorListener=new ExpressionErrorListener();
            SSExprLexer lexer=new SSExprLexer(antlrInputStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);

            CommonTokenStream tokenStream=new CommonTokenStream(lexer);
            SSExprParser parser=new SSExprParser(tokenStream);
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            SSExprParser.StatContext stat = parser.stat();
            List<ErrorInfo> infos=errorListener.getInfos();
            return infos;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public static MyCalVisitor getVisitor() {
        return visitor;
    }
}
