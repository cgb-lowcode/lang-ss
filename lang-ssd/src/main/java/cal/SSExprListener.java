// Generated from D:/workspace_2020_gitlib/ssd-parents/lang-ssd/dsl\SSExpr.g4 by ANTLR 4.9.2
package cal;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SSExprParser}.
 */
public interface SSExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SSExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(SSExprParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(SSExprParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SSExprParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SSExprParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complexExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void enterComplexExprComposite(SSExprParser.ComplexExprCompositeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complexExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void exitComplexExprComposite(SSExprParser.ComplexExprCompositeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void enterSingleExprComposite(SSExprParser.SingleExprCompositeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void exitSingleExprComposite(SSExprParser.SingleExprCompositeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void enterParenExprComposite(SSExprParser.ParenExprCompositeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void exitParenExprComposite(SSExprParser.ParenExprCompositeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleExprLogicComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void enterSingleExprLogicComposite(SSExprParser.SingleExprLogicCompositeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleExprLogicComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void exitSingleExprLogicComposite(SSExprParser.SingleExprLogicCompositeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExprComposite(SSExprParser.TernaryExprCompositeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExprComposite(SSExprParser.TernaryExprCompositeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#forInExpr}.
	 * @param ctx the parse tree
	 */
	void enterForInExpr(SSExprParser.ForInExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#forInExpr}.
	 * @param ctx the parse tree
	 */
	void exitForInExpr(SSExprParser.ForInExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(SSExprParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(SSExprParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#ifPart}.
	 * @param ctx the parse tree
	 */
	void enterIfPart(SSExprParser.IfPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#ifPart}.
	 * @param ctx the parse tree
	 */
	void exitIfPart(SSExprParser.IfPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#elseIfPart}.
	 * @param ctx the parse tree
	 */
	void enterElseIfPart(SSExprParser.ElseIfPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#elseIfPart}.
	 * @param ctx the parse tree
	 */
	void exitElseIfPart(SSExprParser.ElseIfPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void enterElsePart(SSExprParser.ElsePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void exitElsePart(SSExprParser.ElsePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#augassign}.
	 * @param ctx the parse tree
	 */
	void enterAugassign(SSExprParser.AugassignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#augassign}.
	 * @param ctx the parse tree
	 */
	void exitAugassign(SSExprParser.AugassignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SSExprParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SSExprParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#exprBlock}.
	 * @param ctx the parse tree
	 */
	void enterExprBlock(SSExprParser.ExprBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#exprBlock}.
	 * @param ctx the parse tree
	 */
	void exitExprBlock(SSExprParser.ExprBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#eachExpr}.
	 * @param ctx the parse tree
	 */
	void enterEachExpr(SSExprParser.EachExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#eachExpr}.
	 * @param ctx the parse tree
	 */
	void exitEachExpr(SSExprParser.EachExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#returnExpr}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpr(SSExprParser.ReturnExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#returnExpr}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpr(SSExprParser.ReturnExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#consts}.
	 * @param ctx the parse tree
	 */
	void enterConsts(SSExprParser.ConstsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#consts}.
	 * @param ctx the parse tree
	 */
	void exitConsts(SSExprParser.ConstsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprItemItem}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprItemItem(SSExprParser.ExprItemItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprItemItem}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprItemItem(SSExprParser.ExprItemItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprItemUnit}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprItemUnit(SSExprParser.ExprItemUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprItemUnit}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprItemUnit(SSExprParser.ExprItemUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPropDot}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPropDot(SSExprParser.ExprPropDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPropDot}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPropDot(SSExprParser.ExprPropDotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprArrIndex}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprArrIndex(SSExprParser.ExprArrIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprArrIndex}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprArrIndex(SSExprParser.ExprArrIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprDataset}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprDataset(SSExprParser.ExprDatasetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprDataset}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprDataset(SSExprParser.ExprDatasetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#exprLogic}.
	 * @param ctx the parse tree
	 */
	void enterExprLogic(SSExprParser.ExprLogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#exprLogic}.
	 * @param ctx the parse tree
	 */
	void exitExprLogic(SSExprParser.ExprLogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(SSExprParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(SSExprParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(SSExprParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(SSExprParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(SSExprParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(SSExprParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#ternaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(SSExprParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#ternaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(SSExprParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(SSExprParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(SSExprParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#tests}.
	 * @param ctx the parse tree
	 */
	void enterTests(SSExprParser.TestsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#tests}.
	 * @param ctx the parse tree
	 */
	void exitTests(SSExprParser.TestsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleCal}
	 * labeled alternative in {@link SSExprParser#item}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCal(SSExprParser.SimpleCalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleCal}
	 * labeled alternative in {@link SSExprParser#item}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCal(SSExprParser.SimpleCalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link SSExprParser#item}.
	 * @param ctx the parse tree
	 */
	void enterParens(SSExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link SSExprParser#item}.
	 * @param ctx the parse tree
	 */
	void exitParens(SSExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenJoin}
	 * labeled alternative in {@link SSExprParser#item}.
	 * @param ctx the parse tree
	 */
	void enterParenJoin(SSExprParser.ParenJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenJoin}
	 * labeled alternative in {@link SSExprParser#item}.
	 * @param ctx the parse tree
	 */
	void exitParenJoin(SSExprParser.ParenJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleValueLogicUnit}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 */
	void enterSimpleValueLogicUnit(SSExprParser.SimpleValueLogicUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleValueLogicUnit}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 */
	void exitSimpleValueLogicUnit(SSExprParser.SimpleValueLogicUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleCalLogic}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCalLogic(SSExprParser.SimpleCalLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleCalLogic}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCalLogic(SSExprParser.SimpleCalLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensLogic}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 */
	void enterParensLogic(SSExprParser.ParensLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensLogic}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 */
	void exitParensLogic(SSExprParser.ParensLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenJoinLogic}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 */
	void enterParenJoinLogic(SSExprParser.ParenJoinLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenJoinLogic}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 */
	void exitParenJoinLogic(SSExprParser.ParenJoinLogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#properties}.
	 * @param ctx the parse tree
	 */
	void enterProperties(SSExprParser.PropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#properties}.
	 * @param ctx the parse tree
	 */
	void exitProperties(SSExprParser.PropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#orders}.
	 * @param ctx the parse tree
	 */
	void enterOrders(SSExprParser.OrdersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#orders}.
	 * @param ctx the parse tree
	 */
	void exitOrders(SSExprParser.OrdersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#dataset_test}.
	 * @param ctx the parse tree
	 */
	void enterDataset_test(SSExprParser.Dataset_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#dataset_test}.
	 * @param ctx the parse tree
	 */
	void exitDataset_test(SSExprParser.Dataset_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#dataset_tests}.
	 * @param ctx the parse tree
	 */
	void enterDataset_tests(SSExprParser.Dataset_testsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#dataset_tests}.
	 * @param ctx the parse tree
	 */
	void exitDataset_tests(SSExprParser.Dataset_testsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#dataset}.
	 * @param ctx the parse tree
	 */
	void enterDataset(SSExprParser.DatasetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#dataset}.
	 * @param ctx the parse tree
	 */
	void exitDataset(SSExprParser.DatasetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#aggregate}.
	 * @param ctx the parse tree
	 */
	void enterAggregate(SSExprParser.AggregateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#aggregate}.
	 * @param ctx the parse tree
	 */
	void exitAggregate(SSExprParser.AggregateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(SSExprParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(SSExprParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(SSExprParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(SSExprParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(SSExprParser.JsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(SSExprParser.JsonContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(SSExprParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(SSExprParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#arr}.
	 * @param ctx the parse tree
	 */
	void enterArr(SSExprParser.ArrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#arr}.
	 * @param ctx the parse tree
	 */
	void exitArr(SSExprParser.ArrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#simpleValue}.
	 * @param ctx the parse tree
	 */
	void enterSimpleValue(SSExprParser.SimpleValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#simpleValue}.
	 * @param ctx the parse tree
	 */
	void exitSimpleValue(SSExprParser.SimpleValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(SSExprParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(SSExprParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameter(SSExprParser.FunctionParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameter(SSExprParser.FunctionParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#join}.
	 * @param ctx the parse tree
	 */
	void enterJoin(SSExprParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#join}.
	 * @param ctx the parse tree
	 */
	void exitJoin(SSExprParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link SSExprParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SSExprParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SSExprParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SSExprParser.VariableContext ctx);
}