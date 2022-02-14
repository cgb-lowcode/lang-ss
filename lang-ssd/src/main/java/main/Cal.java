package main;

import antlr.CalException;
import antlr.expr.expr.Expr;
import antlr.expr.listens.ExpressionErrorListener;
import antlr.model.data.ExprData;
import cal.SSExprLexer;
import cal.SSExprParser;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class Cal  {

    public static Expr parseExpression(String text)  {
        ANTLRInputStream antlrInputStream=new ANTLRInputStream(text);
        SSExprLexer lexer=new SSExprLexer(antlrInputStream);
        CommonTokenStream tokenStream=new CommonTokenStream(lexer);
        SSExprParser parser=new SSExprParser(tokenStream);
        ExpressionErrorListener errorListener=new ExpressionErrorListener();
        parser.addErrorListener(errorListener);
        MyCalVisitor exprVisitor=new MyCalVisitor();
        Expr expression=exprVisitor.visitStat(parser.stat());
        String error=errorListener.getErrorMessage();
        if(error!=null){
            throw new CalException("Expression parse error:"+error);
        }
        return expression;
    }

    public static void main(String[] args) throws Exception{
        // String expr = FileUtil.readString("e:/test.ss", Charset.forName("UTF-8"));
        //String expr = "";
        //4,3
        //expr += "(1+1)*2\n1+1*2\n";
        //100
        //expr += "变量=-1E1\n变量*变量\n";
        //9,4,7
        //expr += "变量=3\n(1+2)*变量\n(1+2)%2+变量\n(3+3)+1%2+变量%3\n";
        //3
        //expr += "变量=2\n(1%2)+(变量%3)\n";
        //0.5
//        expr += "math(\"sin\",PI/6)\n";
//        expr += "变量=3.14/6\nmath(\"sin\",变量)+2*3\n";

        //Expr expression=parseExpression("(1+1)*3");
        //Expr expression=parseExpression("'ab'+'cd'");
        Expr expression=parseExpression("3>12?'aaa':'bbb'");
        //模拟一个传给语法树的上下文
        Map<String,Object> params = new HashMap();
        params.put("title","外部变量值测试");
        MyExprContext context = new MyExprContext();
        context.setParameters(params);
        ExprData result = expression.run(context);
        System.out.println("result:" + Convert.toStr(result.getData()));
    }
}
