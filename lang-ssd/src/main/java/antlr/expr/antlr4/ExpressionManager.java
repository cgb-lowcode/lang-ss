package antlr.expr.antlr4;

import antlr.CalException;
import antlr.expr.ExpressionCondition;
import antlr.expr.ExpressionConditionList;
import antlr.expr.Tools;
import antlr.expr.antlr4.impl.ExprCompositeImpl;
import antlr.expr.antlr4.impl.IfExprImpl;
import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.builder.aggregate.AggregateFactory;
import antlr.expr.builder.aggregate.IAggregate;
import antlr.expr.expr.*;
import antlr.model.Join;
import antlr.model.Op;
import antlr.model.Operator;
import cal.SSExprParser;
import cal.SSExprParser.*;
import cal.SSExprLexer.*;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import javafx.beans.binding.ListExpression;
import main.MyCalVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpressionManager {
    public static Expr factor(ExpressionContext ctx)  {
        for(ParseTree tree : ctx.children){
            Optional<SSTree> _tree =  Tools.antlr_expressions.stream().filter(s->s.support(tree)).findFirst();
            if(_tree.isPresent()){
                return _tree.get().expr();
            }
        }
        throw new CalException("不支持的表达式：" + ctx.getText());
    }

    public static Expr parseExprLogic(ExprLogicContext _exprContext)  {
        ExprLogicContext exprContext = (ExprLogicContext)_exprContext;
        List<Expr> expressions = new ArrayList<Expr>();
        List<Join> operators = new ArrayList<Join>();

        List<ItemLogicContext> itemContexts = exprContext.itemLogic();
        List<JoinContext> operatorNodes = exprContext.join();
        for (int i = 0; i < itemContexts.size(); i++) {
            ItemLogicContext itemContext = itemContexts.get(i);
            Expr expr = parseItemLogicContext(itemContext);
            expressions.add(expr);
            if (i > 0) {
                JoinContext operatorNode = operatorNodes.get(i - 1);
                String op = operatorNode.getText();
                operators.add(Join.parse(op));
            }
        }
        ParenLogicExpression expression = new ParenLogicExpression(operators, expressions);
        expression.setExpr(exprContext.getText());
        return expression;
    }


    private static TestExpression parseCondExprContext(TestsContext condExprContext)  {
        TestExpression expr = new TestExpression();
        expr.setExpr(condExprContext.getText());
        expr.setConditionList(parseCondtionList(condExprContext.test(), condExprContext.join()));
        return expr;
    }
    public static Expr parseItemLogicContext(ItemLogicContext itemContext)  {
        Expr expression=null;
        if(itemContext instanceof SimpleCalLogicContext){
            SimpleCalLogicContext simpleJoinContext=(SimpleCalLogicContext)itemContext;
            expression=parseSimpleCalLogicContext(simpleJoinContext);
        }else if(itemContext instanceof SimpleValueLogicUnitContext){
            SimpleValueLogicUnitContext simpleJoinContext=(SimpleValueLogicUnitContext)itemContext;
            expression=buildExpression(simpleJoinContext.unit());
        }else if(itemContext instanceof ParenJoinLogicContext){
            ParenJoinLogicContext parenJoinContext=(ParenJoinLogicContext)itemContext;
            expression=parseParenJoinLogicContext(parenJoinContext);
        }else if(itemContext instanceof ParensLogicContext){
            ParensLogicContext singleContext=(ParensLogicContext)itemContext;
            ItemLogicContext childItemContext=singleContext.itemLogic();
            expression=parseItemLogicContext(childItemContext);
        }else{
            throw new CalException("Unknow context :"+itemContext);
        }
        return expression;
    }
    private static Expr parseParenJoinLogicContext(ParenJoinLogicContext ctx)  {
        List<Expr> expressions=new ArrayList<Expr>();
        List<Operator> operators=new ArrayList<Operator>();
        List<ItemLogicContext> itemContexts=ctx.itemLogic();
        List<JoinContext> operatorNodes=ctx.join();
        for(int i=0;i<itemContexts.size();i++){
            ItemLogicContext itemContext=itemContexts.get(i);
            Expr expr=parseItemLogicContext(itemContext);
            expressions.add(expr);
            if(i>0){
                JoinContext operatorNode=operatorNodes.get(i-1);
                String op=operatorNode.getText();
                operators.add(Operator.parse(op));
            }
        }
        ParenExpression expression=new ParenExpression(operators, expressions);
        expression.setExpr(ctx.getText());
        return expression;
    }
    private static Expr parseSimpleCalLogicContext(SimpleCalLogicContext ctx)  {
        TestContext context=ctx.test();
        List<TestContext> testContextList = new ArrayList<>();
        testContextList.add(context);
        TestExpression expr = new TestExpression();
        expr.setExpr(context.getText());
        expr.setConditionList(parseCondtionList(testContextList, null));
        return expr;
    }
    private static Expr parseSimpleCal(SimpleCalContext ctx)  {
        List<Expr> expressions=new ArrayList<Expr>();
        List<Operator> operators=new ArrayList<Operator>();
        List<UnitContext> unitContexts=ctx.unit();
        List<TerminalNode> operatorNodes=ctx.Opertion();
        for(int i=0;i<unitContexts.size();i++){
            UnitContext unitContext=unitContexts.get(i);
            BaseExpr expr=buildExpression(unitContext);
            expressions.add(expr);
            if(i>0){
                TerminalNode operatorNode=operatorNodes.get(i-1);
                String op=operatorNode.getText();
                operators.add(Operator.parse(op));
            }
        }
        if(operators.size()==0 && expressions.size()==1){
            return expressions.get(0);
        }
        JoinExpr expression=new JoinExpr(operators,expressions);
        expression.setExpr(ctx.getText());
        return expression;
    }
    public static Expr parseItemContext(ItemContext itemContext)  {
        Expr expression=null;
        if(itemContext instanceof SimpleCalContext){
            SimpleCalContext simpleJoinContext=(SimpleCalContext)itemContext;
            expression=parseSimpleCal(simpleJoinContext);
        }else if(itemContext instanceof ParenJoinContext){
            ParenJoinContext parenJoinContext=(ParenJoinContext)itemContext;
            expression=parsevisitParenJoin(parenJoinContext);
        }else if(itemContext instanceof ParensContext){
            ParensContext singleContext=(ParensContext)itemContext;
            ItemContext childItemContext=singleContext.item();
            expression=parseItemContext(childItemContext);
        }else{
            throw new CalException("Unknow context :"+itemContext);
        }
        return expression;
    }
    public static Expr parsevisitParenJoin(ParenJoinContext ctx)  {
        List<Expr> expressions=new ArrayList<Expr>();
        List<Operator> operators=new ArrayList<Operator>();
        List<ItemContext> itemContexts=ctx.item();
        List<TerminalNode> operatorNodes=ctx.Opertion();
        for(int i=0;i<itemContexts.size();i++){
            ItemContext itemContext=itemContexts.get(i);
            Expr expr=parseItemContext(itemContext);
            expressions.add(expr);
            if(i>0){
                TerminalNode operatorNode=operatorNodes.get(i-1);
                String op=operatorNode.getText();
                operators.add(Operator.parse(op));
            }
        }
        ParenExpression expression=new ParenExpression(operators, expressions);
        expression.setExpr(ctx.getText());
        return expression;
    }

    //expr: item (Opertion item)*;
    public static Expr parseExpr(ExprContext _exprContext)  {
        if(_exprContext instanceof ExprItemItemContext) {
            ExprItemItemContext exprContext = (ExprItemItemContext)_exprContext;
            List<Expr> expressions = new ArrayList<Expr>();
            List<Operator> operators = new ArrayList<Operator>();

            List<ItemContext> itemContexts = exprContext.item();
            List<TerminalNode> operatorNodes = exprContext.Opertion();
            for (int i = 0; i < itemContexts.size(); i++) {
                ItemContext itemContext = itemContexts.get(i);
                Expr expr = parseItemContext(itemContext);
                expressions.add(expr);
                if (i > 0) {
                    TerminalNode operatorNode = operatorNodes.get(i - 1);
                    String op = operatorNode.getText();
                    operators.add(Operator.parse(op));
                }
            }
            ParenExpression expression = new ParenExpression(operators, expressions);
            expression.setExpr(exprContext.getText());
            return expression;
        }else if(_exprContext instanceof ExprItemUnitContext){
            ExprItemUnitContext exprContext = (ExprItemUnitContext)_exprContext;
            List<Expr> expressions = new ArrayList<Expr>();
            List<Operator> operators = new ArrayList<Operator>();
            ItemContext itemContext =  exprContext.item();
            Expr _expr = parseItemContext(itemContext);
            expressions.add(_expr);

            List<UnitContext> itemContexts = exprContext.unit();
            List<TerminalNode> operatorNodes = exprContext.Opertion();
            for (int i = 0; i < itemContexts.size(); i++) {
                UnitContext unitContext = itemContexts.get(i);
                BaseExpr expr=buildExpression(unitContext);
                expressions.add(expr);
                TerminalNode operatorNode = operatorNodes.get(i);
                String op = operatorNode.getText();
                operators.add(Operator.parse(op));
            }
            ParenExpression expression = new ParenExpression(operators, expressions);
            expression.setExpr(exprContext.getText());
            return expression;
        }else if(_exprContext instanceof ExprPropDotContext){ //属性.运算符计算
            ExprPropDotContext exprContext = (ExprPropDotContext)_exprContext;
            PropDotExpr _expr = new PropDotExpr();
            _expr.setExpression(ExpressionManager.parseExpr(exprContext.expr()));
            _expr.setPropName(exprContext.Identifier().getText());
            return _expr;
        }else if(_exprContext instanceof ExprArrIndexContext){ //数组索引计算
            ExprArrIndexContext exprContext = (ExprArrIndexContext)_exprContext;
            ExprArrIndexExpr _expr = new ExprArrIndexExpr();
            Expr varExpr = ExpressionManager.parseExpr(exprContext.expr(0));
            Expr varIndexExpr = ExpressionManager.parseExpr(exprContext.expr(1));
            _expr.setVariable(varExpr);
            _expr.setIndexExpr(varIndexExpr);
            return _expr;
        }else if(_exprContext instanceof ExprDatasetContext) { //数据集表达式
            ExprDatasetContext exprContext = (ExprDatasetContext)_exprContext;
            AggregateContext aggregate =  exprContext.dataset().aggregate(); //聚合动作，可以是select，max等
            String name = aggregate.Identifier().getText();
            if(StrUtil.startWithAny(name,"'","\"")){
                name = name.substring(1,name.length()-1);
            }
            return new AggreExpr(name,exprContext.dataset());
        }
        else{
            throw new CalException("不支持的表达式：" + _exprContext.getText());
        }
    }
    public static ExpressionConditionList parseCondtionList(List<TestContext> testContext, List<JoinContext> joinContexts)  {
        List<ExpressionCondition> list=new ArrayList<ExpressionCondition>();
        List<Join> joins=new ArrayList<Join>();
        for(int i=0;i<testContext.size();i++){
            TestContext context=testContext.get(i);
            ExprContext left=context.expr(0);
            ExprContext right=context.expr(1);
            Expr leftExpr=parseExpr(left);
            Expr rightExpr=parseExpr(right);
            Op op= Op.parse(context.OP().getText());
            ExpressionCondition condition=new ExpressionCondition(leftExpr,op,rightExpr);
            list.add(condition);
            if(i>0){
                JoinContext joinContext=joinContexts.get(i-1);
                String text=joinContext.getText();
                Join join=Join.and;
                if(text.equals("or") || text.equals("||")){
                    join=Join.or;
                }
                joins.add(join);
            }
        }
        return new ExpressionConditionList(list,joins);
    }
    //语句块
    public static ExpressionBlock parseBlock(BlockContext blockCtx)  {
        List<ExprBlockContext> exprBlockCtxs=blockCtx.exprBlock();
        ReturnExprContext returnCtx=blockCtx.returnExpr();
        ExpressionBlock block=null;
        if(exprBlockCtxs!=null){
            block=parseExpressionBlock(exprBlockCtxs);
        }
        if(returnCtx!=null){
            if(block==null){
                block=new ExpressionBlock();
            }
            if(returnCtx.exprComposite()!=null) {
                Expr _expr = parseExprComposite(returnCtx.exprComposite());
                block.setReturnExpression(_expr);
            }
        }
        return block;
    }
//    public static BaseExpr parseJSON(ArrContext arrContext){
//        return new JSONExpression(arrContext);
//    }
//    public static BaseExpr parseJSONObj(ObjContext objContext){
//        return new JSONExpression(objContext);
//    }

    public static BaseExpr parsePropContext( SSExprParser.PropertiesContext propContext){
        if(propContext.STRING()!=null){
            return new StringExpression(propContext.STRING().getText());
        }else if(propContext.obj()!=null){
            return new JSONExpression(propContext.obj());
        }
        return null;
    }

    public static Expr parseExprComposite(ExprCompositeContext exprCompositeContext)  {
        if(exprCompositeContext instanceof SingleExprCompositeContext){
            SingleExprCompositeContext singleExprCompositeContext=(SingleExprCompositeContext)exprCompositeContext;
            ExprContext exprContext=singleExprCompositeContext.expr();
            return ExpressionManager.parseExpr(exprContext);
        }else if(exprCompositeContext instanceof SingleExprLogicCompositeContext){
            SingleExprLogicCompositeContext c=(SingleExprLogicCompositeContext)exprCompositeContext;
            ExprLogicContext _ctx = c.exprLogic();
            return ExpressionManager.parseExprLogic(_ctx);
        }
        else if(exprCompositeContext instanceof ParenExprCompositeContext){
            ParenExprCompositeContext parenExprCompositeContext=(ParenExprCompositeContext)exprCompositeContext;
            ExprCompositeContext childExprCompositeContext=parenExprCompositeContext.exprComposite();
            return parseExprComposite(childExprCompositeContext);
        }else if(exprCompositeContext instanceof TernaryExprCompositeContext){
            //ternaryExpr : conditions '?' expr ':' expr ;
            TernaryExprCompositeContext ternaryExprCompositeContext=(TernaryExprCompositeContext)exprCompositeContext;
            TernaryExprContext ternaryExprContext=ternaryExprCompositeContext.ternaryExpr();
            List<TestContext> condContext=ternaryExprContext.test();
            IfExpression expr=new IfExpression();
            expr.setConditionList(ExpressionManager.parseCondtionList(condContext, ternaryExprContext.join()));
            BlockContext firstBlockContext=ternaryExprContext.block(0);
            expr.setExpression(ExpressionManager.parseBlock(firstBlockContext));

            BlockContext secondBlockContext=ternaryExprContext.block(1);
            ElseExpression elseExpr=new ElseExpression();
            elseExpr.setExpression(ExpressionManager.parseBlock(secondBlockContext));
            expr.setElseExpression(elseExpr);
            return expr;
        }else if(exprCompositeContext instanceof ComplexExprCompositeContext){
            ComplexExprCompositeContext complexExprCompositeContext=(ComplexExprCompositeContext)exprCompositeContext;
            ExprCompositeContext leftExprCompositeContext=complexExprCompositeContext.exprComposite(0);
            Expr leftExpression=parseExprComposite(leftExprCompositeContext);
            ExprCompositeContext rightExprCompositeContext=complexExprCompositeContext.exprComposite(1);
            Expr rightExpression=parseExprComposite(rightExprCompositeContext);
            String op=complexExprCompositeContext.Opertion().getText();
            Operator operator=Operator.parse(op);
            List<Expr> expressions=new ArrayList<Expr>();
            expressions.add((Expr)leftExpression);
            expressions.add((Expr)rightExpression);
            List<Operator> operators=new ArrayList<Operator>();
            operators.add(operator);
            ParenExpression expression=new ParenExpression(operators, expressions);
            expression.setExpr(complexExprCompositeContext.getText());
            return expression;
        }else{
            throw new CalException("Unknow context :"+exprCompositeContext);
        }
    }

    public static ExpressionBlock parseExpressionBlock(List<ExprBlockContext> contexts)  {
        StringBuilder sb=new StringBuilder();
        List<Expr> expressionList=new ArrayList<Expr>();
        for(ExprBlockContext ctx:contexts){
            sb.append(ctx.getText());
            expressionList.add(factor(ctx.expression()));
        }
        ExpressionBlock blockExpr=new ExpressionBlock();
        blockExpr.setExpressionList(expressionList);
        blockExpr.setExpr(sb.toString());
        return blockExpr;
    }
    public static BaseExpr buildExpression(UnitContext unitContext)  {
        for(ExpressionBuilder builder: Tools.expressionBuilders){
            if(builder.support(unitContext)){
                return builder.build(unitContext);
            }
        }
        throw new CalException("Unknow context :"+unitContext);
    }
}
