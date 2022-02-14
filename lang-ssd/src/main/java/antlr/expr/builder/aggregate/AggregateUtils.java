package antlr.expr.builder.aggregate;

import antlr.CalException;
import antlr.expr.antlr4.ExpressionManager;
import antlr.expr.expr.BaseExpr;
import antlr.expr.expr.Expr;
import antlr.model.Join;
import antlr.model.Op;
import cal.SSExprParser;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import main.MyExprContext;

import java.util.List;

public class AggregateUtils {
    public static String tests2str(MyExprContext context,SSExprParser.Dataset_testsContext c)  {
        StringBuffer sb = new StringBuffer();
        List<SSExprParser.JoinContext> joins = c.join();
        List<SSExprParser.Dataset_testContext> tests = c.dataset_test();
        for(int i=0;i<tests.size();i++){
            SSExprParser.Dataset_testContext test = tests.get(i);
            SSExprParser.JoinContext joinContext = null;
            SSExprParser.ExprContext right = test.expr();
            Expr expr2 = ExpressionManager.parseExpr(right);
            Object rightStr = expr2.run(context).getData();
            if(i>0) {
                joinContext = joins.get(i-1);
            }
            String op = "";

            op = test.OP().getText();
            Op _op = Op.parse(test.OP().getText());
            if (_op.equals(Op.Equals)) {
                op = " = ";
            }else if (_op.equals(Op.NotEquals)) {
                op = " <> ";
            }else if(_op.equals(Op.Like)){
                op = " like ";
            }else if(_op.equals(Op.NotLike)){
                op = " not like ";
            }else if(_op.equals(Op.In)){
                op = " in ";
            }else if(_op.equals(Op.NotIn)){
                op = " not in ";
            }
            if(rightStr == null || rightStr.equals("null")){
                if(op.equals("==")){
                    op = " is";
                }else if(op.equals("!=") || op.equals("<>")){
                    op = " is not ";
                }
            }

            if(joinContext!=null) {
                if (joinContext.AND() != null) {
                    sb.append(" AND ");
                } else {
                    sb.append(" OR ");
                }
            }

            String field = test.Identifier().getText();

            if(rightStr instanceof String){
                rightStr = "'" + StrUtil.replace(Convert.toStr(rightStr),"'","\\'") + "'";
            }else{
                rightStr = Convert.toStr(rightStr);

            }
            sb.append(field + op + rightStr);
        }
        return sb.toString();
    }
}
