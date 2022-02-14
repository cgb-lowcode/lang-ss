// Generated from D:/workspace_2020_gitlib/ssd-parents/lang-ssd/dsl\SSExpr.g4 by ANTLR 4.9.2
package cal;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SSExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, WS=24, NL=25, 
		PI=26, MIU=27, EB=28, EE=29, INTEGER=30, DIGIT=31, NEWLINE=32, Opertion=33, 
		OP=34, LESS_THAN=35, GREATER_THAN=36, EQUALS=37, GT_EQ=38, LT_EQ=39, NOT_EQ_1=40, 
		NOT_EQ_2=41, STAR=42, ADD=43, MINUS=44, DIV=45, MOD=46, AND=47, OR=48, 
		STRING=49, STRING_LITERAL=50, LETTER=51, NUMBER=52, INT=53, EXP=54, Char=55, 
		NULL=56, LeftParen=57, RightParen=58, LEFTBLOCK=59, RIGHTBLOCK=60, ARROW=61, 
		BOOLEAN=62, Identifier=63, IMAG_NUMBER=64, ORDER=65, SKIP_=66;
	public static final int
		RULE_stat = 0, RULE_expression = 1, RULE_exprComposite = 2, RULE_forInExpr = 3, 
		RULE_ifExpr = 4, RULE_ifPart = 5, RULE_elseIfPart = 6, RULE_elsePart = 7, 
		RULE_augassign = 8, RULE_block = 9, RULE_exprBlock = 10, RULE_eachExpr = 11, 
		RULE_returnExpr = 12, RULE_consts = 13, RULE_expr = 14, RULE_exprLogic = 15, 
		RULE_varAssign = 16, RULE_leftHandSide = 17, RULE_arrayAccess = 18, RULE_ternaryExpr = 19, 
		RULE_test = 20, RULE_tests = 21, RULE_item = 22, RULE_itemLogic = 23, 
		RULE_properties = 24, RULE_orders = 25, RULE_dataset_test = 26, RULE_dataset_tests = 27, 
		RULE_dataset = 28, RULE_aggregate = 29, RULE_unit = 30, RULE_pair = 31, 
		RULE_json = 32, RULE_obj = 33, RULE_arr = 34, RULE_simpleValue = 35, RULE_function = 36, 
		RULE_functionParameter = 37, RULE_join = 38, RULE_variable = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"stat", "expression", "exprComposite", "forInExpr", "ifExpr", "ifPart", 
			"elseIfPart", "elsePart", "augassign", "block", "exprBlock", "eachExpr", 
			"returnExpr", "consts", "expr", "exprLogic", "varAssign", "leftHandSide", 
			"arrayAccess", "ternaryExpr", "test", "tests", "item", "itemLogic", "properties", 
			"orders", "dataset_test", "dataset_tests", "dataset", "aggregate", "unit", 
			"pair", "json", "obj", "arr", "simpleValue", "function", "functionParameter", 
			"join", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'for'", "','", "'in'", "'if'", "'else'", "'+='", "'-='", "'*='", 
			"'/='", "'%='", "'.each'", "'return'", "';'", "'['", "']'", "'.'", "'='", 
			"'?'", "':'", "'++'", "'--'", "'!'", "'not'", null, null, "'PI'", "'MIU'", 
			"'EB'", "'EE'", null, null, null, null, null, "'<'", "'>'", "'=='", "'>='", 
			"'<='", "'<>'", "'!='", "'*'", "'+'", "'-'", "'/'", "'%'", null, null, 
			null, null, null, null, null, null, null, "'null'", "'('", "')'", "'{'", 
			"'}'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"WS", "NL", "PI", "MIU", "EB", "EE", "INTEGER", "DIGIT", "NEWLINE", "Opertion", 
			"OP", "LESS_THAN", "GREATER_THAN", "EQUALS", "GT_EQ", "LT_EQ", "NOT_EQ_1", 
			"NOT_EQ_2", "STAR", "ADD", "MINUS", "DIV", "MOD", "AND", "OR", "STRING", 
			"STRING_LITERAL", "LETTER", "NUMBER", "INT", "EXP", "Char", "NULL", "LeftParen", 
			"RightParen", "LEFTBLOCK", "RIGHTBLOCK", "ARROW", "BOOLEAN", "Identifier", 
			"IMAG_NUMBER", "ORDER", "SKIP_"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SSExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SSExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StatContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SSExprParser.EOF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(80);
				expression();
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (T__3 - 1)) | (1L << (T__11 - 1)) | (1L << (T__13 - 1)) | (1L << (T__19 - 1)) | (1L << (T__20 - 1)) | (1L << (T__21 - 1)) | (1L << (T__22 - 1)) | (1L << (PI - 1)) | (1L << (MIU - 1)) | (1L << (EB - 1)) | (1L << (EE - 1)) | (1L << (INTEGER - 1)) | (1L << (STRING - 1)) | (1L << (NUMBER - 1)) | (1L << (NULL - 1)) | (1L << (LeftParen - 1)) | (1L << (LEFTBLOCK - 1)) | (1L << (BOOLEAN - 1)) | (1L << (Identifier - 1)) | (1L << (IMAG_NUMBER - 1)))) != 0) );
			setState(85);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExprCompositeContext exprComposite() {
			return getRuleContext(ExprCompositeContext.class,0);
		}
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public ForInExprContext forInExpr() {
			return getRuleContext(ForInExprContext.class,0);
		}
		public ReturnExprContext returnExpr() {
			return getRuleContext(ReturnExprContext.class,0);
		}
		public VarAssignContext varAssign() {
			return getRuleContext(VarAssignContext.class,0);
		}
		public EachExprContext eachExpr() {
			return getRuleContext(EachExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				exprComposite(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				ifExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				forInExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				returnExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				varAssign();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
				eachExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprCompositeContext extends ParserRuleContext {
		public ExprCompositeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprComposite; }
	 
		public ExprCompositeContext() { }
		public void copyFrom(ExprCompositeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexExprCompositeContext extends ExprCompositeContext {
		public List<ExprCompositeContext> exprComposite() {
			return getRuleContexts(ExprCompositeContext.class);
		}
		public ExprCompositeContext exprComposite(int i) {
			return getRuleContext(ExprCompositeContext.class,i);
		}
		public TerminalNode Opertion() { return getToken(SSExprParser.Opertion, 0); }
		public ComplexExprCompositeContext(ExprCompositeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterComplexExprComposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitComplexExprComposite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitComplexExprComposite(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExprCompositeContext extends ExprCompositeContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SingleExprCompositeContext(ExprCompositeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterSingleExprComposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitSingleExprComposite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitSingleExprComposite(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprCompositeContext extends ExprCompositeContext {
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public ExprCompositeContext exprComposite() {
			return getRuleContext(ExprCompositeContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public ParenExprCompositeContext(ExprCompositeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterParenExprComposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitParenExprComposite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitParenExprComposite(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExprLogicCompositeContext extends ExprCompositeContext {
		public ExprLogicContext exprLogic() {
			return getRuleContext(ExprLogicContext.class,0);
		}
		public SingleExprLogicCompositeContext(ExprCompositeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterSingleExprLogicComposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitSingleExprLogicComposite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitSingleExprLogicComposite(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExprCompositeContext extends ExprCompositeContext {
		public TernaryExprContext ternaryExpr() {
			return getRuleContext(TernaryExprContext.class,0);
		}
		public TernaryExprCompositeContext(ExprCompositeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterTernaryExprComposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitTernaryExprComposite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitTernaryExprComposite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprCompositeContext exprComposite() throws RecognitionException {
		return exprComposite(0);
	}

	private ExprCompositeContext exprComposite(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprCompositeContext _localctx = new ExprCompositeContext(_ctx, _parentState);
		ExprCompositeContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_exprComposite, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				_localctx = new SingleExprCompositeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(96);
				expr(0);
				}
				break;
			case 2:
				{
				_localctx = new SingleExprLogicCompositeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				exprLogic();
				}
				break;
			case 3:
				{
				_localctx = new TernaryExprCompositeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				ternaryExpr();
				}
				break;
			case 4:
				{
				_localctx = new ParenExprCompositeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(LeftParen);
				setState(100);
				exprComposite(0);
				setState(101);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComplexExprCompositeContext(new ExprCompositeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exprComposite);
					setState(105);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(106);
					match(Opertion);
					setState(107);
					exprComposite(2);
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ForInExprContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public TerminalNode LEFTBLOCK() { return getToken(SSExprParser.LEFTBLOCK, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RIGHTBLOCK() { return getToken(SSExprParser.RIGHTBLOCK, 0); }
		public ForInExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterForInExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitForInExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitForInExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInExprContext forInExpr() throws RecognitionException {
		ForInExprContext _localctx = new ForInExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_forInExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__0);
			setState(114);
			match(LeftParen);
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(115);
				variable();
				setState(116);
				match(T__1);
				}
				break;
			}
			setState(120);
			variable();
			setState(121);
			match(T__2);
			setState(122);
			unit();
			setState(123);
			match(RightParen);
			setState(124);
			match(LEFTBLOCK);
			setState(125);
			block();
			setState(126);
			match(RIGHTBLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfExprContext extends ParserRuleContext {
		public IfPartContext ifPart() {
			return getRuleContext(IfPartContext.class,0);
		}
		public List<ElseIfPartContext> elseIfPart() {
			return getRuleContexts(ElseIfPartContext.class);
		}
		public ElseIfPartContext elseIfPart(int i) {
			return getRuleContext(ElseIfPartContext.class,i);
		}
		public ElsePartContext elsePart() {
			return getRuleContext(ElsePartContext.class,0);
		}
		public IfExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitIfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExprContext ifExpr() throws RecognitionException {
		IfExprContext _localctx = new IfExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			ifPart();
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(129);
					elseIfPart();
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(135);
				elsePart();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfPartContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public TestsContext tests() {
			return getRuleContext(TestsContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public TerminalNode LEFTBLOCK() { return getToken(SSExprParser.LEFTBLOCK, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RIGHTBLOCK() { return getToken(SSExprParser.RIGHTBLOCK, 0); }
		public IfPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterIfPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitIfPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitIfPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfPartContext ifPart() throws RecognitionException {
		IfPartContext _localctx = new IfPartContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__3);
			setState(139);
			match(LeftParen);
			setState(140);
			tests();
			setState(141);
			match(RightParen);
			setState(142);
			match(LEFTBLOCK);
			setState(143);
			block();
			setState(144);
			match(RIGHTBLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseIfPartContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public TestsContext tests() {
			return getRuleContext(TestsContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public TerminalNode LEFTBLOCK() { return getToken(SSExprParser.LEFTBLOCK, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RIGHTBLOCK() { return getToken(SSExprParser.RIGHTBLOCK, 0); }
		public ElseIfPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterElseIfPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitElseIfPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitElseIfPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfPartContext elseIfPart() throws RecognitionException {
		ElseIfPartContext _localctx = new ElseIfPartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elseIfPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__4);
			setState(147);
			match(T__3);
			setState(148);
			match(LeftParen);
			setState(149);
			tests();
			setState(150);
			match(RightParen);
			setState(151);
			match(LEFTBLOCK);
			setState(152);
			block();
			setState(153);
			match(RIGHTBLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElsePartContext extends ParserRuleContext {
		public TerminalNode LEFTBLOCK() { return getToken(SSExprParser.LEFTBLOCK, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RIGHTBLOCK() { return getToken(SSExprParser.RIGHTBLOCK, 0); }
		public ElsePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterElsePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitElsePart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitElsePart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsePartContext elsePart() throws RecognitionException {
		ElsePartContext _localctx = new ElsePartContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elsePart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(T__4);
			setState(156);
			match(LEFTBLOCK);
			setState(157);
			block();
			setState(158);
			match(RIGHTBLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AugassignContext extends ParserRuleContext {
		public AugassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_augassign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterAugassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitAugassign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitAugassign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AugassignContext augassign() throws RecognitionException {
		AugassignContext _localctx = new AugassignContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_augassign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<ExprBlockContext> exprBlock() {
			return getRuleContexts(ExprBlockContext.class);
		}
		public ExprBlockContext exprBlock(int i) {
			return getRuleContext(ExprBlockContext.class,i);
		}
		public ReturnExprContext returnExpr() {
			return getRuleContext(ReturnExprContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(162);
					exprBlock();
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(168);
				returnExpr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprBlockContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterExprBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitExprBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitExprBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprBlockContext exprBlock() throws RecognitionException {
		ExprBlockContext _localctx = new ExprBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exprBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EachExprContext extends ParserRuleContext {
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(SSExprParser.ARROW, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public TerminalNode LEFTBLOCK() { return getToken(SSExprParser.LEFTBLOCK, 0); }
		public TerminalNode RIGHTBLOCK() { return getToken(SSExprParser.RIGHTBLOCK, 0); }
		public EachExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eachExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterEachExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitEachExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitEachExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EachExprContext eachExpr() throws RecognitionException {
		EachExprContext _localctx = new EachExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_eachExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			unit();
			setState(174);
			match(T__10);
			setState(175);
			match(LeftParen);
			setState(176);
			variable();
			setState(177);
			match(ARROW);
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(178);
				match(LEFTBLOCK);
				}
				break;
			}
			setState(181);
			block();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RIGHTBLOCK) {
				{
				setState(182);
				match(RIGHTBLOCK);
				}
			}

			setState(185);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnExprContext extends ParserRuleContext {
		public ExprCompositeContext exprComposite() {
			return getRuleContext(ExprCompositeContext.class,0);
		}
		public ReturnExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterReturnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitReturnExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitReturnExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnExprContext returnExpr() throws RecognitionException {
		ReturnExprContext _localctx = new ReturnExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(187);
				match(T__11);
				}
			}

			setState(190);
			exprComposite(0);
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(191);
				match(T__12);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstsContext extends ParserRuleContext {
		public TerminalNode PI() { return getToken(SSExprParser.PI, 0); }
		public TerminalNode EE() { return getToken(SSExprParser.EE, 0); }
		public TerminalNode EB() { return getToken(SSExprParser.EB, 0); }
		public TerminalNode MIU() { return getToken(SSExprParser.MIU, 0); }
		public ConstsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterConsts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitConsts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitConsts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstsContext consts() throws RecognitionException {
		ConstsContext _localctx = new ConstsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_consts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PI) | (1L << MIU) | (1L << EB) | (1L << EE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprItemItemContext extends ExprContext {
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<TerminalNode> Opertion() { return getTokens(SSExprParser.Opertion); }
		public TerminalNode Opertion(int i) {
			return getToken(SSExprParser.Opertion, i);
		}
		public ExprItemItemContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterExprItemItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitExprItemItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitExprItemItem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprItemUnitContext extends ExprContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public List<TerminalNode> Opertion() { return getTokens(SSExprParser.Opertion); }
		public TerminalNode Opertion(int i) {
			return getToken(SSExprParser.Opertion, i);
		}
		public List<UnitContext> unit() {
			return getRuleContexts(UnitContext.class);
		}
		public UnitContext unit(int i) {
			return getRuleContext(UnitContext.class,i);
		}
		public ExprItemUnitContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterExprItemUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitExprItemUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitExprItemUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprPropDotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SSExprParser.Identifier, 0); }
		public ExprPropDotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterExprPropDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitExprPropDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitExprPropDot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprArrIndexContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprArrIndexContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterExprArrIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitExprArrIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitExprArrIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDatasetContext extends ExprContext {
		public DatasetContext dataset() {
			return getRuleContext(DatasetContext.class,0);
		}
		public ExprDatasetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterExprDataset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitExprDataset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitExprDataset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new ExprDatasetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(197);
				dataset();
				}
				break;
			case 2:
				{
				_localctx = new ExprItemUnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				item();
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(199);
						match(Opertion);
						setState(200);
						unit();
						}
						} 
					}
					setState(205);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				}
				break;
			case 3:
				{
				_localctx = new ExprItemItemContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				item();
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(207);
						match(Opertion);
						setState(208);
						item();
						}
						} 
					}
					setState(213);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(224);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprArrIndexContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(216);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(217);
						match(T__13);
						setState(218);
						expr(0);
						setState(219);
						match(T__14);
						}
						break;
					case 2:
						{
						_localctx = new ExprPropDotContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(222);
						match(T__15);
						setState(223);
						match(Identifier);
						}
						break;
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprLogicContext extends ParserRuleContext {
		public List<ItemLogicContext> itemLogic() {
			return getRuleContexts(ItemLogicContext.class);
		}
		public ItemLogicContext itemLogic(int i) {
			return getRuleContext(ItemLogicContext.class,i);
		}
		public List<JoinContext> join() {
			return getRuleContexts(JoinContext.class);
		}
		public JoinContext join(int i) {
			return getRuleContext(JoinContext.class,i);
		}
		public ExprLogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprLogic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterExprLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitExprLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitExprLogic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprLogicContext exprLogic() throws RecognitionException {
		ExprLogicContext _localctx = new ExprLogicContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exprLogic);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			itemLogic();
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(230);
					join();
					setState(231);
					itemLogic();
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarAssignContext extends ParserRuleContext {
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public ExprCompositeContext exprComposite() {
			return getRuleContext(ExprCompositeContext.class,0);
		}
		public AugassignContext augassign() {
			return getRuleContext(AugassignContext.class,0);
		}
		public VarAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterVarAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitVarAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitVarAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAssignContext varAssign() throws RecognitionException {
		VarAssignContext _localctx = new VarAssignContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			leftHandSide();
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				{
				setState(239);
				match(T__16);
				}
				break;
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
				{
				setState(240);
				augassign();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(243);
			exprComposite(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeftHandSideContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public LeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitLeftHandSide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitLeftHandSide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftHandSideContext leftHandSide() throws RecognitionException {
		LeftHandSideContext _localctx = new LeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_leftHandSide);
		try {
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				arrayAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccessContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			variable();
			setState(250);
			match(T__13);
			setState(251);
			expr(0);
			setState(252);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TernaryExprContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<JoinContext> join() {
			return getRuleContexts(JoinContext.class);
		}
		public JoinContext join(int i) {
			return getRuleContext(JoinContext.class,i);
		}
		public TernaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterTernaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitTernaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitTernaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryExprContext ternaryExpr() throws RecognitionException {
		TernaryExprContext _localctx = new TernaryExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ternaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			test();
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(255);
				join();
				setState(256);
				test();
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(263);
			match(T__17);
			setState(264);
			block();
			setState(265);
			match(T__18);
			setState(266);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TestContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP() { return getToken(SSExprParser.OP, 0); }
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_test);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			expr(0);
			setState(269);
			match(OP);
			setState(270);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TestsContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<JoinContext> join() {
			return getRuleContexts(JoinContext.class);
		}
		public JoinContext join(int i) {
			return getRuleContext(JoinContext.class,i);
		}
		public TestsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tests; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterTests(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitTests(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitTests(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestsContext tests() throws RecognitionException {
		TestsContext _localctx = new TestsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_tests);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			test();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(273);
				join();
				setState(274);
				test();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemContext extends ParserRuleContext {
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	 
		public ItemContext() { }
		public void copyFrom(ItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensContext extends ItemContext {
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public ParensContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenJoinContext extends ItemContext {
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public List<TerminalNode> Opertion() { return getTokens(SSExprParser.Opertion); }
		public TerminalNode Opertion(int i) {
			return getToken(SSExprParser.Opertion, i);
		}
		public ParenJoinContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterParenJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitParenJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitParenJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleCalContext extends ItemContext {
		public List<UnitContext> unit() {
			return getRuleContexts(UnitContext.class);
		}
		public UnitContext unit(int i) {
			return getRuleContext(UnitContext.class,i);
		}
		public List<TerminalNode> Opertion() { return getTokens(SSExprParser.Opertion); }
		public TerminalNode Opertion(int i) {
			return getToken(SSExprParser.Opertion, i);
		}
		public SimpleCalContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterSimpleCal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitSimpleCal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitSimpleCal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_item);
		int _la;
		try {
			int _alt;
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new SimpleCalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				unit();
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(282);
						match(Opertion);
						setState(283);
						unit();
						}
						} 
					}
					setState(288);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(LeftParen);
				setState(290);
				item();
				setState(291);
				match(RightParen);
				}
				break;
			case 3:
				_localctx = new ParenJoinContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				match(LeftParen);
				setState(294);
				item();
				setState(297); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(295);
					match(Opertion);
					setState(296);
					item();
					}
					}
					setState(299); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Opertion );
				setState(301);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemLogicContext extends ParserRuleContext {
		public ItemLogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemLogic; }
	 
		public ItemLogicContext() { }
		public void copyFrom(ItemLogicContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleValueLogicUnitContext extends ItemLogicContext {
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public SimpleValueLogicUnitContext(ItemLogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterSimpleValueLogicUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitSimpleValueLogicUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitSimpleValueLogicUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleCalLogicContext extends ItemLogicContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public SimpleCalLogicContext(ItemLogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterSimpleCalLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitSimpleCalLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitSimpleCalLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenJoinLogicContext extends ItemLogicContext {
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public List<ItemLogicContext> itemLogic() {
			return getRuleContexts(ItemLogicContext.class);
		}
		public ItemLogicContext itemLogic(int i) {
			return getRuleContext(ItemLogicContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public List<JoinContext> join() {
			return getRuleContexts(JoinContext.class);
		}
		public JoinContext join(int i) {
			return getRuleContext(JoinContext.class,i);
		}
		public ParenJoinLogicContext(ItemLogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterParenJoinLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitParenJoinLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitParenJoinLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensLogicContext extends ItemLogicContext {
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public ItemLogicContext itemLogic() {
			return getRuleContext(ItemLogicContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public ParensLogicContext(ItemLogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterParensLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitParensLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitParensLogic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemLogicContext itemLogic() throws RecognitionException {
		ItemLogicContext _localctx = new ItemLogicContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_itemLogic);
		int _la;
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new SimpleValueLogicUnitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				unit();
				}
				break;
			case 2:
				_localctx = new SimpleCalLogicContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				test();
				}
				break;
			case 3:
				_localctx = new ParensLogicContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				match(LeftParen);
				setState(308);
				itemLogic();
				setState(309);
				match(RightParen);
				}
				break;
			case 4:
				_localctx = new ParenJoinLogicContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(311);
				match(LeftParen);
				setState(312);
				itemLogic();
				setState(316); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(313);
					join();
					setState(314);
					itemLogic();
					}
					}
					setState(318); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==AND || _la==OR );
				setState(320);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertiesContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SSExprParser.STRING, 0); }
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertiesContext properties() throws RecognitionException {
		PropertiesContext _localctx = new PropertiesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_properties);
		try {
			setState(326);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				match(STRING);
				}
				break;
			case LEFTBLOCK:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				obj();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrdersContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SSExprParser.STRING, 0); }
		public OrdersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orders; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterOrders(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitOrders(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitOrders(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrdersContext orders() throws RecognitionException {
		OrdersContext _localctx = new OrdersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_orders);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dataset_testContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SSExprParser.Identifier, 0); }
		public TerminalNode OP() { return getToken(SSExprParser.OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Dataset_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataset_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterDataset_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitDataset_test(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitDataset_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dataset_testContext dataset_test() throws RecognitionException {
		Dataset_testContext _localctx = new Dataset_testContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dataset_test);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(Identifier);
			setState(331);
			match(OP);
			setState(332);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dataset_testsContext extends ParserRuleContext {
		public List<Dataset_testContext> dataset_test() {
			return getRuleContexts(Dataset_testContext.class);
		}
		public Dataset_testContext dataset_test(int i) {
			return getRuleContext(Dataset_testContext.class,i);
		}
		public List<JoinContext> join() {
			return getRuleContexts(JoinContext.class);
		}
		public JoinContext join(int i) {
			return getRuleContext(JoinContext.class,i);
		}
		public Dataset_testsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataset_tests; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterDataset_tests(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitDataset_tests(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitDataset_tests(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dataset_testsContext dataset_tests() throws RecognitionException {
		Dataset_testsContext _localctx = new Dataset_testsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_dataset_tests);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			dataset_test();
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(335);
				join();
				setState(336);
				dataset_test();
				}
				}
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatasetContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(SSExprParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SSExprParser.Identifier, i);
		}
		public AggregateContext aggregate() {
			return getRuleContext(AggregateContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public PropertiesContext properties() {
			return getRuleContext(PropertiesContext.class,0);
		}
		public Dataset_testsContext dataset_tests() {
			return getRuleContext(Dataset_testsContext.class,0);
		}
		public OrdersContext orders() {
			return getRuleContext(OrdersContext.class,0);
		}
		public DatasetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterDataset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitDataset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitDataset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatasetContext dataset() throws RecognitionException {
		DatasetContext _localctx = new DatasetContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_dataset);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(Identifier);
			setState(344);
			match(T__15);
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(345);
				match(Identifier);
				setState(346);
				match(T__15);
				}
				break;
			}
			setState(349);
			aggregate();
			setState(350);
			match(LeftParen);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING || _la==LEFTBLOCK) {
				{
				setState(351);
				properties();
				}
			}

			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(354);
				match(T__1);
				setState(355);
				dataset_tests();
				}
				break;
			}
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(358);
				match(T__1);
				setState(359);
				orders();
				}
			}

			setState(362);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregateContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SSExprParser.Identifier, 0); }
		public AggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterAggregate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitAggregate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitAggregate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateContext aggregate() throws RecognitionException {
		AggregateContext _localctx = new AggregateContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_aggregate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnitContext extends ParserRuleContext {
		public Token op;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ConstsContext consts() {
			return getRuleContext(ConstsContext.class,0);
		}
		public SimpleValueContext simpleValue() {
			return getRuleContext(SimpleValueContext.class,0);
		}
		public JsonContext json() {
			return getRuleContext(JsonContext.class,0);
		}
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_unit);
		int _la;
		try {
			setState(378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				variable();
				setState(367);
				((UnitContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
					((UnitContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				((UnitContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
					((UnitContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(370);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(371);
				((UnitContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
					((UnitContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(372);
				variable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(373);
				function();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(374);
				variable();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(375);
				consts();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(376);
				simpleValue();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(377);
				json();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SSExprParser.STRING, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(STRING);
			setState(381);
			match(T__18);
			setState(382);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JsonContext extends ParserRuleContext {
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public ArrContext arr() {
			return getRuleContext(ArrContext.class,0);
		}
		public JsonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterJson(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitJson(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitJson(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonContext json() throws RecognitionException {
		JsonContext _localctx = new JsonContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_json);
		try {
			setState(386);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFTBLOCK:
				enterOuterAlt(_localctx, 1);
				{
				setState(384);
				obj();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				arr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjContext extends ParserRuleContext {
		public TerminalNode LEFTBLOCK() { return getToken(SSExprParser.LEFTBLOCK, 0); }
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public TerminalNode RIGHTBLOCK() { return getToken(SSExprParser.RIGHTBLOCK, 0); }
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_obj);
		int _la;
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				match(LEFTBLOCK);
				setState(389);
				pair();
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(390);
					match(T__1);
					setState(391);
					pair();
					}
					}
					setState(396);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(397);
				match(RIGHTBLOCK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				match(LEFTBLOCK);
				setState(400);
				match(RIGHTBLOCK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrContext extends ParserRuleContext {
		public List<UnitContext> unit() {
			return getRuleContexts(UnitContext.class);
		}
		public UnitContext unit(int i) {
			return getRuleContext(UnitContext.class,i);
		}
		public List<ObjContext> obj() {
			return getRuleContexts(ObjContext.class);
		}
		public ObjContext obj(int i) {
			return getRuleContext(ObjContext.class,i);
		}
		public ArrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterArr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitArr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitArr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrContext arr() throws RecognitionException {
		ArrContext _localctx = new ArrContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_arr);
		int _la;
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				match(T__13);
				setState(404);
				unit();
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(405);
					match(T__1);
					setState(406);
					unit();
					}
					}
					setState(411);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(412);
				match(T__14);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				match(T__13);
				setState(415);
				obj();
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(416);
					match(T__1);
					setState(417);
					obj();
					}
					}
					setState(422);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(423);
				match(T__14);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				match(T__13);
				setState(426);
				match(T__14);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleValueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SSExprParser.INTEGER, 0); }
		public TerminalNode NUMBER() { return getToken(SSExprParser.NUMBER, 0); }
		public TerminalNode IMAG_NUMBER() { return getToken(SSExprParser.IMAG_NUMBER, 0); }
		public TerminalNode STRING() { return getToken(SSExprParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(SSExprParser.BOOLEAN, 0); }
		public TerminalNode NULL() { return getToken(SSExprParser.NULL, 0); }
		public SimpleValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterSimpleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitSimpleValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitSimpleValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleValueContext simpleValue() throws RecognitionException {
		SimpleValueContext _localctx = new SimpleValueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_simpleValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			_la = _input.LA(1);
			if ( !(((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (INTEGER - 30)) | (1L << (STRING - 30)) | (1L << (NUMBER - 30)) | (1L << (NULL - 30)) | (1L << (BOOLEAN - 30)) | (1L << (IMAG_NUMBER - 30)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SSExprParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(SSExprParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SSExprParser.RightParen, 0); }
		public FunctionParameterContext functionParameter() {
			return getRuleContext(FunctionParameterContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			match(Identifier);
			setState(432);
			match(LeftParen);
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__19 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (PI - 14)) | (1L << (MIU - 14)) | (1L << (EB - 14)) | (1L << (EE - 14)) | (1L << (INTEGER - 14)) | (1L << (STRING - 14)) | (1L << (NUMBER - 14)) | (1L << (NULL - 14)) | (1L << (LeftParen - 14)) | (1L << (LEFTBLOCK - 14)) | (1L << (BOOLEAN - 14)) | (1L << (Identifier - 14)) | (1L << (IMAG_NUMBER - 14)))) != 0)) {
				{
				setState(433);
				functionParameter();
				}
			}

			setState(436);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionParameterContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterFunctionParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitFunctionParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitFunctionParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParameterContext functionParameter() throws RecognitionException {
		FunctionParameterContext _localctx = new FunctionParameterContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_functionParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			expr(0);
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__13 - 2)) | (1L << (T__19 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__22 - 2)) | (1L << (PI - 2)) | (1L << (MIU - 2)) | (1L << (EB - 2)) | (1L << (EE - 2)) | (1L << (INTEGER - 2)) | (1L << (STRING - 2)) | (1L << (NUMBER - 2)) | (1L << (NULL - 2)) | (1L << (LeftParen - 2)) | (1L << (LEFTBLOCK - 2)) | (1L << (BOOLEAN - 2)) | (1L << (Identifier - 2)) | (1L << (IMAG_NUMBER - 2)))) != 0)) {
				{
				{
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(439);
					match(T__1);
					}
				}

				setState(442);
				expr(0);
				}
				}
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(SSExprParser.AND, 0); }
		public TerminalNode OR() { return getToken(SSExprParser.OR, 0); }
		public JoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitJoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinContext join() throws RecognitionException {
		JoinContext _localctx = new JoinContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SSExprParser.Identifier, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SSExprListener ) ((SSExprListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SSExprVisitor ) return ((SSExprVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return exprComposite_sempred((ExprCompositeContext)_localctx, predIndex);
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprComposite_sempred(ExprCompositeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3D\u01c7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\6\2T\n\2\r"+
		"\2\16\2U\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3`\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4j\n\4\3\4\3\4\3\4\7\4o\n\4\f\4\16\4r\13\4\3\5\3\5\3\5"+
		"\3\5\3\5\5\5y\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\7\6\u0085\n"+
		"\6\f\6\16\6\u0088\13\6\3\6\5\6\u008b\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\7\13\u00a6\n\13\f\13\16\13\u00a9\13\13\3\13\5\13\u00ac\n\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b6\n\r\3\r\3\r\5\r\u00ba\n\r\3\r\3\r\3\16"+
		"\5\16\u00bf\n\16\3\16\3\16\5\16\u00c3\n\16\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\7\20\u00cc\n\20\f\20\16\20\u00cf\13\20\3\20\3\20\3\20\7\20\u00d4"+
		"\n\20\f\20\16\20\u00d7\13\20\5\20\u00d9\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u00e3\n\20\f\20\16\20\u00e6\13\20\3\21\3\21\3\21"+
		"\3\21\7\21\u00ec\n\21\f\21\16\21\u00ef\13\21\3\22\3\22\3\22\5\22\u00f4"+
		"\n\22\3\22\3\22\3\23\3\23\5\23\u00fa\n\23\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\7\25\u0105\n\25\f\25\16\25\u0108\13\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u0117\n\27\f\27"+
		"\16\27\u011a\13\27\3\30\3\30\3\30\7\30\u011f\n\30\f\30\16\30\u0122\13"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\6\30\u012c\n\30\r\30\16\30"+
		"\u012d\3\30\3\30\5\30\u0132\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\6\31\u013f\n\31\r\31\16\31\u0140\3\31\3\31\5\31\u0145"+
		"\n\31\3\32\3\32\5\32\u0149\n\32\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\7\35\u0155\n\35\f\35\16\35\u0158\13\35\3\36\3\36\3\36\3\36"+
		"\5\36\u015e\n\36\3\36\3\36\3\36\5\36\u0163\n\36\3\36\3\36\5\36\u0167\n"+
		"\36\3\36\3\36\5\36\u016b\n\36\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \5 \u017d\n \3!\3!\3!\3!\3\"\3\"\5\"\u0185\n\"\3#\3#\3"+
		"#\3#\7#\u018b\n#\f#\16#\u018e\13#\3#\3#\3#\3#\5#\u0194\n#\3$\3$\3$\3$"+
		"\7$\u019a\n$\f$\16$\u019d\13$\3$\3$\3$\3$\3$\3$\7$\u01a5\n$\f$\16$\u01a8"+
		"\13$\3$\3$\3$\3$\5$\u01ae\n$\3%\3%\3&\3&\3&\5&\u01b5\n&\3&\3&\3\'\3\'"+
		"\5\'\u01bb\n\'\3\'\7\'\u01be\n\'\f\'\16\'\u01c1\13\'\3(\3(\3)\3)\3)\2"+
		"\4\6\36*\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNP\2\b\3\2\b\f\3\2\34\37\3\2\26\27\3\2\30\31\b\2  \63\63\66"+
		"\66::@@BB\3\2\61\62\2\u01db\2S\3\2\2\2\4_\3\2\2\2\6i\3\2\2\2\bs\3\2\2"+
		"\2\n\u0082\3\2\2\2\f\u008c\3\2\2\2\16\u0094\3\2\2\2\20\u009d\3\2\2\2\22"+
		"\u00a2\3\2\2\2\24\u00a7\3\2\2\2\26\u00ad\3\2\2\2\30\u00af\3\2\2\2\32\u00be"+
		"\3\2\2\2\34\u00c4\3\2\2\2\36\u00d8\3\2\2\2 \u00e7\3\2\2\2\"\u00f0\3\2"+
		"\2\2$\u00f9\3\2\2\2&\u00fb\3\2\2\2(\u0100\3\2\2\2*\u010e\3\2\2\2,\u0112"+
		"\3\2\2\2.\u0131\3\2\2\2\60\u0144\3\2\2\2\62\u0148\3\2\2\2\64\u014a\3\2"+
		"\2\2\66\u014c\3\2\2\28\u0150\3\2\2\2:\u0159\3\2\2\2<\u016e\3\2\2\2>\u017c"+
		"\3\2\2\2@\u017e\3\2\2\2B\u0184\3\2\2\2D\u0193\3\2\2\2F\u01ad\3\2\2\2H"+
		"\u01af\3\2\2\2J\u01b1\3\2\2\2L\u01b8\3\2\2\2N\u01c2\3\2\2\2P\u01c4\3\2"+
		"\2\2RT\5\4\3\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\2"+
		"\2\3X\3\3\2\2\2Y`\5\6\4\2Z`\5\n\6\2[`\5\b\5\2\\`\5\32\16\2]`\5\"\22\2"+
		"^`\5\30\r\2_Y\3\2\2\2_Z\3\2\2\2_[\3\2\2\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2"+
		"\2`\5\3\2\2\2ab\b\4\1\2bj\5\36\20\2cj\5 \21\2dj\5(\25\2ef\7;\2\2fg\5\6"+
		"\4\2gh\7<\2\2hj\3\2\2\2ia\3\2\2\2ic\3\2\2\2id\3\2\2\2ie\3\2\2\2jp\3\2"+
		"\2\2kl\f\3\2\2lm\7#\2\2mo\5\6\4\4nk\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2"+
		"\2\2q\7\3\2\2\2rp\3\2\2\2st\7\3\2\2tx\7;\2\2uv\5P)\2vw\7\4\2\2wy\3\2\2"+
		"\2xu\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\5P)\2{|\7\5\2\2|}\5> \2}~\7<\2\2~\177"+
		"\7=\2\2\177\u0080\5\24\13\2\u0080\u0081\7>\2\2\u0081\t\3\2\2\2\u0082\u0086"+
		"\5\f\7\2\u0083\u0085\5\16\b\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2"+
		"\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0089\u008b\5\20\t\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2"+
		"\u008b\13\3\2\2\2\u008c\u008d\7\6\2\2\u008d\u008e\7;\2\2\u008e\u008f\5"+
		",\27\2\u008f\u0090\7<\2\2\u0090\u0091\7=\2\2\u0091\u0092\5\24\13\2\u0092"+
		"\u0093\7>\2\2\u0093\r\3\2\2\2\u0094\u0095\7\7\2\2\u0095\u0096\7\6\2\2"+
		"\u0096\u0097\7;\2\2\u0097\u0098\5,\27\2\u0098\u0099\7<\2\2\u0099\u009a"+
		"\7=\2\2\u009a\u009b\5\24\13\2\u009b\u009c\7>\2\2\u009c\17\3\2\2\2\u009d"+
		"\u009e\7\7\2\2\u009e\u009f\7=\2\2\u009f\u00a0\5\24\13\2\u00a0\u00a1\7"+
		">\2\2\u00a1\21\3\2\2\2\u00a2\u00a3\t\2\2\2\u00a3\23\3\2\2\2\u00a4\u00a6"+
		"\5\26\f\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2"+
		"\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac"+
		"\5\32\16\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\25\3\2\2\2\u00ad"+
		"\u00ae\5\4\3\2\u00ae\27\3\2\2\2\u00af\u00b0\5> \2\u00b0\u00b1\7\r\2\2"+
		"\u00b1\u00b2\7;\2\2\u00b2\u00b3\5P)\2\u00b3\u00b5\7?\2\2\u00b4\u00b6\7"+
		"=\2\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b9\5\24\13\2\u00b8\u00ba\7>\2\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3"+
		"\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7<\2\2\u00bc\31\3\2\2\2\u00bd\u00bf"+
		"\7\16\2\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2"+
		"\u00c0\u00c2\5\6\4\2\u00c1\u00c3\7\17\2\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3"+
		"\3\2\2\2\u00c3\33\3\2\2\2\u00c4\u00c5\t\3\2\2\u00c5\35\3\2\2\2\u00c6\u00c7"+
		"\b\20\1\2\u00c7\u00d9\5:\36\2\u00c8\u00cd\5.\30\2\u00c9\u00ca\7#\2\2\u00ca"+
		"\u00cc\5> \2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2"+
		"\2\u00cd\u00ce\3\2\2\2\u00ce\u00d9\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d5"+
		"\5.\30\2\u00d1\u00d2\7#\2\2\u00d2\u00d4\5.\30\2\u00d3\u00d1\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d9\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00c6\3\2\2\2\u00d8\u00c8\3\2\2\2\u00d8"+
		"\u00d0\3\2\2\2\u00d9\u00e4\3\2\2\2\u00da\u00db\f\6\2\2\u00db\u00dc\7\20"+
		"\2\2\u00dc\u00dd\5\36\20\2\u00dd\u00de\7\21\2\2\u00de\u00e3\3\2\2\2\u00df"+
		"\u00e0\f\5\2\2\u00e0\u00e1\7\22\2\2\u00e1\u00e3\7A\2\2\u00e2\u00da\3\2"+
		"\2\2\u00e2\u00df\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\37\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00ed\5\60\31"+
		"\2\u00e8\u00e9\5N(\2\u00e9\u00ea\5\60\31\2\u00ea\u00ec\3\2\2\2\u00eb\u00e8"+
		"\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"!\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\5$\23\2\u00f1\u00f4\7\23\2\2"+
		"\u00f2\u00f4\5\22\n\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\u00f6\5\6\4\2\u00f6#\3\2\2\2\u00f7\u00fa\5P)\2\u00f8\u00fa"+
		"\5&\24\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa%\3\2\2\2\u00fb"+
		"\u00fc\5P)\2\u00fc\u00fd\7\20\2\2\u00fd\u00fe\5\36\20\2\u00fe\u00ff\7"+
		"\21\2\2\u00ff\'\3\2\2\2\u0100\u0106\5*\26\2\u0101\u0102\5N(\2\u0102\u0103"+
		"\5*\26\2\u0103\u0105\3\2\2\2\u0104\u0101\3\2\2\2\u0105\u0108\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u0106\3\2"+
		"\2\2\u0109\u010a\7\24\2\2\u010a\u010b\5\24\13\2\u010b\u010c\7\25\2\2\u010c"+
		"\u010d\5\24\13\2\u010d)\3\2\2\2\u010e\u010f\5\36\20\2\u010f\u0110\7$\2"+
		"\2\u0110\u0111\5\36\20\2\u0111+\3\2\2\2\u0112\u0118\5*\26\2\u0113\u0114"+
		"\5N(\2\u0114\u0115\5*\26\2\u0115\u0117\3\2\2\2\u0116\u0113\3\2\2\2\u0117"+
		"\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119-\3\2\2\2"+
		"\u011a\u0118\3\2\2\2\u011b\u0120\5> \2\u011c\u011d\7#\2\2\u011d\u011f"+
		"\5> \2\u011e\u011c\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0132\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\7;"+
		"\2\2\u0124\u0125\5.\30\2\u0125\u0126\7<\2\2\u0126\u0132\3\2\2\2\u0127"+
		"\u0128\7;\2\2\u0128\u012b\5.\30\2\u0129\u012a\7#\2\2\u012a\u012c\5.\30"+
		"\2\u012b\u0129\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e"+
		"\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7<\2\2\u0130\u0132\3\2\2\2\u0131"+
		"\u011b\3\2\2\2\u0131\u0123\3\2\2\2\u0131\u0127\3\2\2\2\u0132/\3\2\2\2"+
		"\u0133\u0145\5> \2\u0134\u0145\5*\26\2\u0135\u0136\7;\2\2\u0136\u0137"+
		"\5\60\31\2\u0137\u0138\7<\2\2\u0138\u0145\3\2\2\2\u0139\u013a\7;\2\2\u013a"+
		"\u013e\5\60\31\2\u013b\u013c\5N(\2\u013c\u013d\5\60\31\2\u013d\u013f\3"+
		"\2\2\2\u013e\u013b\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\7<\2\2\u0143\u0145\3\2"+
		"\2\2\u0144\u0133\3\2\2\2\u0144\u0134\3\2\2\2\u0144\u0135\3\2\2\2\u0144"+
		"\u0139\3\2\2\2\u0145\61\3\2\2\2\u0146\u0149\7\63\2\2\u0147\u0149\5D#\2"+
		"\u0148\u0146\3\2\2\2\u0148\u0147\3\2\2\2\u0149\63\3\2\2\2\u014a\u014b"+
		"\7\63\2\2\u014b\65\3\2\2\2\u014c\u014d\7A\2\2\u014d\u014e\7$\2\2\u014e"+
		"\u014f\5\36\20\2\u014f\67\3\2\2\2\u0150\u0156\5\66\34\2\u0151\u0152\5"+
		"N(\2\u0152\u0153\5\66\34\2\u0153\u0155\3\2\2\2\u0154\u0151\3\2\2\2\u0155"+
		"\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u01579\3\2\2\2"+
		"\u0158\u0156\3\2\2\2\u0159\u015a\7A\2\2\u015a\u015d\7\22\2\2\u015b\u015c"+
		"\7A\2\2\u015c\u015e\7\22\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0160\5<\37\2\u0160\u0162\7;\2\2\u0161\u0163\5\62"+
		"\32\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0166\3\2\2\2\u0164"+
		"\u0165\7\4\2\2\u0165\u0167\58\35\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2"+
		"\2\2\u0167\u016a\3\2\2\2\u0168\u0169\7\4\2\2\u0169\u016b\5\64\33\2\u016a"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\7<"+
		"\2\2\u016d;\3\2\2\2\u016e\u016f\7A\2\2\u016f=\3\2\2\2\u0170\u0171\5P)"+
		"\2\u0171\u0172\t\4\2\2\u0172\u017d\3\2\2\2\u0173\u0174\t\4\2\2\u0174\u017d"+
		"\5P)\2\u0175\u0176\t\5\2\2\u0176\u017d\5P)\2\u0177\u017d\5J&\2\u0178\u017d"+
		"\5P)\2\u0179\u017d\5\34\17\2\u017a\u017d\5H%\2\u017b\u017d\5B\"\2\u017c"+
		"\u0170\3\2\2\2\u017c\u0173\3\2\2\2\u017c\u0175\3\2\2\2\u017c\u0177\3\2"+
		"\2\2\u017c\u0178\3\2\2\2\u017c\u0179\3\2\2\2\u017c\u017a\3\2\2\2\u017c"+
		"\u017b\3\2\2\2\u017d?\3\2\2\2\u017e\u017f\7\63\2\2\u017f\u0180\7\25\2"+
		"\2\u0180\u0181\5\36\20\2\u0181A\3\2\2\2\u0182\u0185\5D#\2\u0183\u0185"+
		"\5F$\2\u0184\u0182\3\2\2\2\u0184\u0183\3\2\2\2\u0185C\3\2\2\2\u0186\u0187"+
		"\7=\2\2\u0187\u018c\5@!\2\u0188\u0189\7\4\2\2\u0189\u018b\5@!\2\u018a"+
		"\u0188\3\2\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2"+
		"\2\2\u018d\u018f\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0190\7>\2\2\u0190"+
		"\u0194\3\2\2\2\u0191\u0192\7=\2\2\u0192\u0194\7>\2\2\u0193\u0186\3\2\2"+
		"\2\u0193\u0191\3\2\2\2\u0194E\3\2\2\2\u0195\u0196\7\20\2\2\u0196\u019b"+
		"\5> \2\u0197\u0198\7\4\2\2\u0198\u019a\5> \2\u0199\u0197\3\2\2\2\u019a"+
		"\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019e\3\2"+
		"\2\2\u019d\u019b\3\2\2\2\u019e\u019f\7\21\2\2\u019f\u01ae\3\2\2\2\u01a0"+
		"\u01a1\7\20\2\2\u01a1\u01a6\5D#\2\u01a2\u01a3\7\4\2\2\u01a3\u01a5\5D#"+
		"\2\u01a4\u01a2\3\2\2\2\u01a5\u01a8\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7"+
		"\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9\u01aa\7\21\2\2"+
		"\u01aa\u01ae\3\2\2\2\u01ab\u01ac\7\20\2\2\u01ac\u01ae\7\21\2\2\u01ad\u0195"+
		"\3\2\2\2\u01ad\u01a0\3\2\2\2\u01ad\u01ab\3\2\2\2\u01aeG\3\2\2\2\u01af"+
		"\u01b0\t\6\2\2\u01b0I\3\2\2\2\u01b1\u01b2\7A\2\2\u01b2\u01b4\7;\2\2\u01b3"+
		"\u01b5\5L\'\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\3\2"+
		"\2\2\u01b6\u01b7\7<\2\2\u01b7K\3\2\2\2\u01b8\u01bf\5\36\20\2\u01b9\u01bb"+
		"\7\4\2\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"\u01be\5\36\20\2\u01bd\u01ba\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3"+
		"\2\2\2\u01bf\u01c0\3\2\2\2\u01c0M\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c3"+
		"\t\7\2\2\u01c3O\3\2\2\2\u01c4\u01c5\7A\2\2\u01c5Q\3\2\2\2.U_ipx\u0086"+
		"\u008a\u00a7\u00ab\u00b5\u00b9\u00be\u00c2\u00cd\u00d5\u00d8\u00e2\u00e4"+
		"\u00ed\u00f3\u00f9\u0106\u0118\u0120\u012d\u0131\u0140\u0144\u0148\u0156"+
		"\u015d\u0162\u0166\u016a\u017c\u0184\u018c\u0193\u019b\u01a6\u01ad\u01b4"+
		"\u01ba\u01bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}