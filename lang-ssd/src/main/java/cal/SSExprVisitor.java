// Generated from D:/workspace_2020_gitlib/ssd-parents/lang-ssd/dsl\SSExpr.g4 by ANTLR 4.9.2
package cal;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SSExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SSExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SSExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(SSExprParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SSExprParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code complexExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexExprComposite(SSExprParser.ComplexExprCompositeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExprComposite(SSExprParser.SingleExprCompositeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExprComposite(SSExprParser.ParenExprCompositeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleExprLogicComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExprLogicComposite(SSExprParser.SingleExprLogicCompositeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExprComposite}
	 * labeled alternative in {@link SSExprParser#exprComposite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExprComposite(SSExprParser.TernaryExprCompositeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#forInExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInExpr(SSExprParser.ForInExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#ifExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(SSExprParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#ifPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfPart(SSExprParser.IfPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#elseIfPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfPart(SSExprParser.ElseIfPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#elsePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsePart(SSExprParser.ElsePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#augassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugassign(SSExprParser.AugassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SSExprParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#exprBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBlock(SSExprParser.ExprBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#eachExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEachExpr(SSExprParser.EachExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#returnExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpr(SSExprParser.ReturnExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#consts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsts(SSExprParser.ConstsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprItemItem}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprItemItem(SSExprParser.ExprItemItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprItemUnit}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprItemUnit(SSExprParser.ExprItemUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPropDot}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPropDot(SSExprParser.ExprPropDotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArrIndex}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArrIndex(SSExprParser.ExprArrIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprDataset}
	 * labeled alternative in {@link SSExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDataset(SSExprParser.ExprDatasetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#exprLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLogic(SSExprParser.ExprLogicContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#varAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(SSExprParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(SSExprParser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(SSExprParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#ternaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpr(SSExprParser.TernaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(SSExprParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#tests}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTests(SSExprParser.TestsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleCal}
	 * labeled alternative in {@link SSExprParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCal(SSExprParser.SimpleCalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link SSExprParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(SSExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenJoin}
	 * labeled alternative in {@link SSExprParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenJoin(SSExprParser.ParenJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleValueLogicUnit}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleValueLogicUnit(SSExprParser.SimpleValueLogicUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleCalLogic}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCalLogic(SSExprParser.SimpleCalLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensLogic}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensLogic(SSExprParser.ParensLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenJoinLogic}
	 * labeled alternative in {@link SSExprParser#itemLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenJoinLogic(SSExprParser.ParenJoinLogicContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(SSExprParser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#orders}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrders(SSExprParser.OrdersContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#dataset_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataset_test(SSExprParser.Dataset_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#dataset_tests}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataset_tests(SSExprParser.Dataset_testsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#dataset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataset(SSExprParser.DatasetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#aggregate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregate(SSExprParser.AggregateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(SSExprParser.UnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(SSExprParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#json}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson(SSExprParser.JsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(SSExprParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr(SSExprParser.ArrContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#simpleValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleValue(SSExprParser.SimpleValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(SSExprParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#functionParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameter(SSExprParser.FunctionParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin(SSExprParser.JoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link SSExprParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SSExprParser.VariableContext ctx);
}