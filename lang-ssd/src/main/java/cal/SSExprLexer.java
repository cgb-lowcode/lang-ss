// Generated from D:/workspace_2020_gitlib/ssd-parents/lang-ssd/dsl\SSExpr.g4 by ANTLR 4.9.2
package cal;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SSExprLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "WS", "NL", "PI", 
			"MIU", "EB", "EE", "INTEGER", "DIGIT", "NEWLINE", "Opertion", "OP", "LESS_THAN", 
			"GREATER_THAN", "EQUALS", "GT_EQ", "LT_EQ", "NOT_EQ_1", "NOT_EQ_2", "STAR", 
			"ADD", "MINUS", "DIV", "MOD", "AND", "OR", "StartChar", "STRING", "STRING_LITERAL", 
			"SHORT_STRING", "LONG_STRING", "LONG_STRING_ITEM", "STRING_ESCAPE_SEQ", 
			"LONG_STRING_CHAR", "STRING_CONTENT", "EscapeSequence", "OctalEscape", 
			"UnicodeEscape", "HEX", "LETTER", "NUMBER", "INT", "EXP", "Char", "NULL", 
			"LeftParen", "RightParen", "LEFTBLOCK", "RIGHTBLOCK", "ARROW", "BOOLEAN", 
			"Identifier", "IMAG_NUMBER", "ORDER", "SKIP_", "SPACES", "LINE_JOINING", 
			"COMMENT"
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


	public SSExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SSExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u0263\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\31\6\31\u00ec\n\31\r\31\16\31\u00ed\3\31\3\31\3\32\5"+
		"\32\u00f3\n\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\37\5\37\u0107\n\37\3\37\6\37\u010a\n"+
		"\37\r\37\16\37\u010b\3 \3 \3!\5!\u0111\n!\3!\3!\3\"\3\"\3\"\3\"\3\"\5"+
		"\"\u011a\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\5#\u012f\n#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*"+
		"\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\5\60\u0153"+
		"\n\60\3\61\3\61\3\61\3\61\5\61\u0159\n\61\3\62\5\62\u015c\n\62\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\5\64\u0165\n\64\3\64\3\64\5\64\u0169\n\64"+
		"\3\65\3\65\3\65\7\65\u016e\n\65\f\65\16\65\u0171\13\65\3\65\3\65\3\65"+
		"\3\65\7\65\u0177\n\65\f\65\16\65\u017a\13\65\3\65\5\65\u017d\n\65\3\66"+
		"\3\66\3\66\3\66\3\66\7\66\u0184\n\66\f\66\16\66\u0187\13\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\7\66\u0191\n\66\f\66\16\66\u0194\13\66"+
		"\3\66\3\66\3\66\5\66\u0199\n\66\3\67\3\67\5\67\u019d\n\67\38\38\38\38"+
		"\58\u01a3\n8\39\39\3:\3:\7:\u01a9\n:\f:\16:\u01ac\13:\3;\3;\3;\3;\5;\u01b2"+
		"\n;\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u01bd\n<\3=\3=\3=\3=\3=\3=\3=\3>\3>"+
		"\3?\6?\u01c9\n?\r?\16?\u01ca\3@\5@\u01ce\n@\3@\6@\u01d1\n@\r@\16@\u01d2"+
		"\3@\3@\6@\u01d7\n@\r@\16@\u01d8\3@\5@\u01dc\n@\3@\5@\u01df\n@\3@\6@\u01e2"+
		"\n@\r@\16@\u01e3\3@\3@\3@\5@\u01e9\n@\3@\6@\u01ec\n@\r@\16@\u01ed\5@\u01f0"+
		"\n@\3A\6A\u01f3\nA\rA\16A\u01f4\3B\3B\5B\u01f9\nB\3B\6B\u01fc\nB\rB\16"+
		"B\u01fd\3C\3C\3C\3C\5C\u0204\nC\3D\3D\3D\3D\3D\3E\3E\3F\3F\3G\3G\3H\3"+
		"H\3I\3I\3I\3J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u021f\nJ\3K\3K\7K\u0223\nK\f"+
		"K\16K\u0226\13K\3L\3L\5L\u022a\nL\3L\3L\3M\3M\3M\3M\3M\3M\3M\5M\u0235"+
		"\nM\3N\3N\3N\5N\u023a\nN\3N\3N\3O\6O\u023f\nO\rO\16O\u0240\3P\3P\5P\u0245"+
		"\nP\3P\5P\u0248\nP\3P\3P\5P\u024c\nP\3Q\3Q\3Q\3Q\7Q\u0252\nQ\fQ\16Q\u0255"+
		"\13Q\3Q\3Q\3Q\3Q\7Q\u025b\nQ\fQ\16Q\u025e\13Q\3Q\3Q\5Q\u0262\nQ\5\u0185"+
		"\u0192\u025c\2R\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\2e\63"+
		"g\64i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\65\177\66\u0081\67\u00838\u00859\u0087"+
		":\u0089;\u008b<\u008d=\u008f>\u0091?\u0093@\u0095A\u0097B\u0099C\u009b"+
		"D\u009d\2\u009f\2\u00a1\2\3\2\26\5\2\13\f\17\17\"\"\3\2\62;\t\2C\\c|\u2072"+
		"\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2\uffff\b\2HHTTWWhhttw"+
		"w\4\2HHhh\4\2TTtt\6\2\f\f\16\17))^^\6\2\f\f\16\17$$^^\3\2^^\4\2$$))\n"+
		"\2$$))^^ddhhppttvv\5\2\62;CHch\3\2C\\\4\2GGgg\4\2--//\4\2//aa\5\2\u00b9"+
		"\u00b9\u0302\u0371\u2041\u2042\4\2LLll\4\2\13\13\"\"\4\2\f\f\16\17\2\u0299"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2"+
		"\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\3\u00a3"+
		"\3\2\2\2\5\u00a7\3\2\2\2\7\u00a9\3\2\2\2\t\u00ac\3\2\2\2\13\u00af\3\2"+
		"\2\2\r\u00b4\3\2\2\2\17\u00b7\3\2\2\2\21\u00ba\3\2\2\2\23\u00bd\3\2\2"+
		"\2\25\u00c0\3\2\2\2\27\u00c3\3\2\2\2\31\u00c9\3\2\2\2\33\u00d0\3\2\2\2"+
		"\35\u00d2\3\2\2\2\37\u00d4\3\2\2\2!\u00d6\3\2\2\2#\u00d8\3\2\2\2%\u00da"+
		"\3\2\2\2\'\u00dc\3\2\2\2)\u00de\3\2\2\2+\u00e1\3\2\2\2-\u00e4\3\2\2\2"+
		"/\u00e6\3\2\2\2\61\u00eb\3\2\2\2\63\u00f2\3\2\2\2\65\u00f8\3\2\2\2\67"+
		"\u00fb\3\2\2\29\u00ff\3\2\2\2;\u0102\3\2\2\2=\u0106\3\2\2\2?\u010d\3\2"+
		"\2\2A\u0110\3\2\2\2C\u0119\3\2\2\2E\u012e\3\2\2\2G\u0130\3\2\2\2I\u0132"+
		"\3\2\2\2K\u0134\3\2\2\2M\u0137\3\2\2\2O\u013a\3\2\2\2Q\u013d\3\2\2\2S"+
		"\u0140\3\2\2\2U\u0143\3\2\2\2W\u0145\3\2\2\2Y\u0147\3\2\2\2[\u0149\3\2"+
		"\2\2]\u014b\3\2\2\2_\u0152\3\2\2\2a\u0158\3\2\2\2c\u015b\3\2\2\2e\u015d"+
		"\3\2\2\2g\u0164\3\2\2\2i\u017c\3\2\2\2k\u0198\3\2\2\2m\u019c\3\2\2\2o"+
		"\u01a2\3\2\2\2q\u01a4\3\2\2\2s\u01aa\3\2\2\2u\u01b1\3\2\2\2w\u01bc\3\2"+
		"\2\2y\u01be\3\2\2\2{\u01c5\3\2\2\2}\u01c8\3\2\2\2\177\u01ef\3\2\2\2\u0081"+
		"\u01f2\3\2\2\2\u0083\u01f6\3\2\2\2\u0085\u0203\3\2\2\2\u0087\u0205\3\2"+
		"\2\2\u0089\u020a\3\2\2\2\u008b\u020c\3\2\2\2\u008d\u020e\3\2\2\2\u008f"+
		"\u0210\3\2\2\2\u0091\u0212\3\2\2\2\u0093\u021e\3\2\2\2\u0095\u0220\3\2"+
		"\2\2\u0097\u0229\3\2\2\2\u0099\u0234\3\2\2\2\u009b\u0239\3\2\2\2\u009d"+
		"\u023e\3\2\2\2\u009f\u0242\3\2\2\2\u00a1\u0261\3\2\2\2\u00a3\u00a4\7h"+
		"\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7t\2\2\u00a6\4\3\2\2\2\u00a7\u00a8"+
		"\7.\2\2\u00a8\6\3\2\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7p\2\2\u00ab\b"+
		"\3\2\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7h\2\2\u00ae\n\3\2\2\2\u00af\u00b0"+
		"\7g\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7u\2\2\u00b2\u00b3\7g\2\2\u00b3"+
		"\f\3\2\2\2\u00b4\u00b5\7-\2\2\u00b5\u00b6\7?\2\2\u00b6\16\3\2\2\2\u00b7"+
		"\u00b8\7/\2\2\u00b8\u00b9\7?\2\2\u00b9\20\3\2\2\2\u00ba\u00bb\7,\2\2\u00bb"+
		"\u00bc\7?\2\2\u00bc\22\3\2\2\2\u00bd\u00be\7\61\2\2\u00be\u00bf\7?\2\2"+
		"\u00bf\24\3\2\2\2\u00c0\u00c1\7\'\2\2\u00c1\u00c2\7?\2\2\u00c2\26\3\2"+
		"\2\2\u00c3\u00c4\7\60\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7c\2\2\u00c6"+
		"\u00c7\7e\2\2\u00c7\u00c8\7j\2\2\u00c8\30\3\2\2\2\u00c9\u00ca\7t\2\2\u00ca"+
		"\u00cb\7g\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\7t\2\2"+
		"\u00ce\u00cf\7p\2\2\u00cf\32\3\2\2\2\u00d0\u00d1\7=\2\2\u00d1\34\3\2\2"+
		"\2\u00d2\u00d3\7]\2\2\u00d3\36\3\2\2\2\u00d4\u00d5\7_\2\2\u00d5 \3\2\2"+
		"\2\u00d6\u00d7\7\60\2\2\u00d7\"\3\2\2\2\u00d8\u00d9\7?\2\2\u00d9$\3\2"+
		"\2\2\u00da\u00db\7A\2\2\u00db&\3\2\2\2\u00dc\u00dd\7<\2\2\u00dd(\3\2\2"+
		"\2\u00de\u00df\7-\2\2\u00df\u00e0\7-\2\2\u00e0*\3\2\2\2\u00e1\u00e2\7"+
		"/\2\2\u00e2\u00e3\7/\2\2\u00e3,\3\2\2\2\u00e4\u00e5\7#\2\2\u00e5.\3\2"+
		"\2\2\u00e6\u00e7\7p\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7v\2\2\u00e9\60"+
		"\3\2\2\2\u00ea\u00ec\t\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b\31"+
		"\2\2\u00f0\62\3\2\2\2\u00f1\u00f3\7\17\2\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7\f\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\b\32\2\2\u00f7\64\3\2\2\2\u00f8\u00f9\7R\2\2\u00f9\u00fa\7K\2\2"+
		"\u00fa\66\3\2\2\2\u00fb\u00fc\7O\2\2\u00fc\u00fd\7K\2\2\u00fd\u00fe\7"+
		"W\2\2\u00fe8\3\2\2\2\u00ff\u0100\7G\2\2\u0100\u0101\7D\2\2\u0101:\3\2"+
		"\2\2\u0102\u0103\7G\2\2\u0103\u0104\7G\2\2\u0104<\3\2\2\2\u0105\u0107"+
		"\7/\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108"+
		"\u010a\5? \2\u0109\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2"+
		"\2\u010b\u010c\3\2\2\2\u010c>\3\2\2\2\u010d\u010e\t\3\2\2\u010e@\3\2\2"+
		"\2\u010f\u0111\7\17\2\2\u0110\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\7\f\2\2\u0113B\3\2\2\2\u0114\u011a\5W,\2\u0115"+
		"\u011a\5Y-\2\u0116\u011a\5U+\2\u0117\u011a\5[.\2\u0118\u011a\5]/\2\u0119"+
		"\u0114\3\2\2\2\u0119\u0115\3\2\2\2\u0119\u0116\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u0119\u0118\3\2\2\2\u011aD\3\2\2\2\u011b\u012f\5I%\2\u011c\u012f"+
		"\5G$\2\u011d\u012f\5K&\2\u011e\u012f\5Q)\2\u011f\u012f\5S*\2\u0120\u012f"+
		"\5M\'\2\u0121\u012f\5O(\2\u0122\u0123\7n\2\2\u0123\u0124\7k\2\2\u0124"+
		"\u0125\7m\2\2\u0125\u012f\7g\2\2\u0126\u0127\7p\2\2\u0127\u0128\7q\2\2"+
		"\u0128\u0129\7v\2\2\u0129\u012a\7\"\2\2\u012a\u012b\7n\2\2\u012b\u012c"+
		"\7k\2\2\u012c\u012d\7m\2\2\u012d\u012f\7g\2\2\u012e\u011b\3\2\2\2\u012e"+
		"\u011c\3\2\2\2\u012e\u011d\3\2\2\2\u012e\u011e\3\2\2\2\u012e\u011f\3\2"+
		"\2\2\u012e\u0120\3\2\2\2\u012e\u0121\3\2\2\2\u012e\u0122\3\2\2\2\u012e"+
		"\u0126\3\2\2\2\u012fF\3\2\2\2\u0130\u0131\7>\2\2\u0131H\3\2\2\2\u0132"+
		"\u0133\7@\2\2\u0133J\3\2\2\2\u0134\u0135\7?\2\2\u0135\u0136\7?\2\2\u0136"+
		"L\3\2\2\2\u0137\u0138\7@\2\2\u0138\u0139\7?\2\2\u0139N\3\2\2\2\u013a\u013b"+
		"\7>\2\2\u013b\u013c\7?\2\2\u013cP\3\2\2\2\u013d\u013e\7>\2\2\u013e\u013f"+
		"\7@\2\2\u013fR\3\2\2\2\u0140\u0141\7#\2\2\u0141\u0142\7?\2\2\u0142T\3"+
		"\2\2\2\u0143\u0144\7,\2\2\u0144V\3\2\2\2\u0145\u0146\7-\2\2\u0146X\3\2"+
		"\2\2\u0147\u0148\7/\2\2\u0148Z\3\2\2\2\u0149\u014a\7\61\2\2\u014a\\\3"+
		"\2\2\2\u014b\u014c\7\'\2\2\u014c^\3\2\2\2\u014d\u014e\7c\2\2\u014e\u014f"+
		"\7p\2\2\u014f\u0153\7f\2\2\u0150\u0151\7(\2\2\u0151\u0153\7(\2\2\u0152"+
		"\u014d\3\2\2\2\u0152\u0150\3\2\2\2\u0153`\3\2\2\2\u0154\u0155\7q\2\2\u0155"+
		"\u0159\7t\2\2\u0156\u0157\7~\2\2\u0157\u0159\7~\2\2\u0158\u0154\3\2\2"+
		"\2\u0158\u0156\3\2\2\2\u0159b\3\2\2\2\u015a\u015c\t\4\2\2\u015b\u015a"+
		"\3\2\2\2\u015cd\3\2\2\2\u015d\u015e\5g\64\2\u015ef\3\2\2\2\u015f\u0165"+
		"\t\5\2\2\u0160\u0161\t\6\2\2\u0161\u0165\t\7\2\2\u0162\u0163\t\7\2\2\u0163"+
		"\u0165\t\6\2\2\u0164\u015f\3\2\2\2\u0164\u0160\3\2\2\2\u0164\u0162\3\2"+
		"\2\2\u0164\u0165\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0169\5i\65\2\u0167"+
		"\u0169\5k\66\2\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169h\3\2\2\2"+
		"\u016a\u016f\7)\2\2\u016b\u016e\5o8\2\u016c\u016e\n\b\2\2\u016d\u016b"+
		"\3\2\2\2\u016d\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u017d\7)"+
		"\2\2\u0173\u0178\7$\2\2\u0174\u0177\5o8\2\u0175\u0177\n\t\2\2\u0176\u0174"+
		"\3\2\2\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017d\7$"+
		"\2\2\u017c\u016a\3\2\2\2\u017c\u0173\3\2\2\2\u017dj\3\2\2\2\u017e\u017f"+
		"\7)\2\2\u017f\u0180\7)\2\2\u0180\u0181\7)\2\2\u0181\u0185\3\2\2\2\u0182"+
		"\u0184\5m\67\2\u0183\u0182\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0186\3\2"+
		"\2\2\u0185\u0183\3\2\2\2\u0186\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188"+
		"\u0189\7)\2\2\u0189\u018a\7)\2\2\u018a\u0199\7)\2\2\u018b\u018c\7$\2\2"+
		"\u018c\u018d\7$\2\2\u018d\u018e\7$\2\2\u018e\u0192\3\2\2\2\u018f\u0191"+
		"\5m\67\2\u0190\u018f\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0193\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0196\7$"+
		"\2\2\u0196\u0197\7$\2\2\u0197\u0199\7$\2\2\u0198\u017e\3\2\2\2\u0198\u018b"+
		"\3\2\2\2\u0199l\3\2\2\2\u019a\u019d\5q9\2\u019b\u019d\5o8\2\u019c\u019a"+
		"\3\2\2\2\u019c\u019b\3\2\2\2\u019dn\3\2\2\2\u019e\u019f\7^\2\2\u019f\u01a3"+
		"\13\2\2\2\u01a0\u01a1\7^\2\2\u01a1\u01a3\5A!\2\u01a2\u019e\3\2\2\2\u01a2"+
		"\u01a0\3\2\2\2\u01a3p\3\2\2\2\u01a4\u01a5\n\n\2\2\u01a5r\3\2\2\2\u01a6"+
		"\u01a9\5u;\2\u01a7\u01a9\n\13\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a7\3\2"+
		"\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"t\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01ae\7^\2\2\u01ae\u01b2\t\f\2\2\u01af"+
		"\u01b2\5y=\2\u01b0\u01b2\5w<\2\u01b1\u01ad\3\2\2\2\u01b1\u01af\3\2\2\2"+
		"\u01b1\u01b0\3\2\2\2\u01b2v\3\2\2\2\u01b3\u01b4\7^\2\2\u01b4\u01b5\4\62"+
		"\65\2\u01b5\u01b6\4\629\2\u01b6\u01bd\4\629\2\u01b7\u01b8\7^\2\2\u01b8"+
		"\u01b9\4\629\2\u01b9\u01bd\4\629\2\u01ba\u01bb\7^\2\2\u01bb\u01bd\4\62"+
		"9\2\u01bc\u01b3\3\2\2\2\u01bc\u01b7\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd"+
		"x\3\2\2\2\u01be\u01bf\7^\2\2\u01bf\u01c0\7w\2\2\u01c0\u01c1\5{>\2\u01c1"+
		"\u01c2\5{>\2\u01c2\u01c3\5{>\2\u01c3\u01c4\5{>\2\u01c4z\3\2\2\2\u01c5"+
		"\u01c6\t\r\2\2\u01c6|\3\2\2\2\u01c7\u01c9\t\16\2\2\u01c8\u01c7\3\2\2\2"+
		"\u01c9\u01ca\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb~\3"+
		"\2\2\2\u01cc\u01ce\7/\2\2\u01cd\u01cc\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce"+
		"\u01d0\3\2\2\2\u01cf\u01d1\5? \2\u01d0\u01cf\3\2\2\2\u01d1\u01d2\3\2\2"+
		"\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d6"+
		"\7\60\2\2\u01d5\u01d7\5? \2\u01d6\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01dc\5\u0083"+
		"B\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01f0\3\2\2\2\u01dd"+
		"\u01df\7/\2\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e1\3\2"+
		"\2\2\u01e0\u01e2\5? \2\u01e1\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e1"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\5\u0083B"+
		"\2\u01e6\u01f0\3\2\2\2\u01e7\u01e9\7/\2\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9"+
		"\3\2\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01ec\5? \2\u01eb\u01ea\3\2\2\2\u01ec"+
		"\u01ed\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01f0\3\2"+
		"\2\2\u01ef\u01cd\3\2\2\2\u01ef\u01de\3\2\2\2\u01ef\u01e8\3\2\2\2\u01f0"+
		"\u0080\3\2\2\2\u01f1\u01f3\t\3\2\2\u01f2\u01f1\3\2\2\2\u01f3\u01f4\3\2"+
		"\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u0082\3\2\2\2\u01f6"+
		"\u01f8\t\17\2\2\u01f7\u01f9\t\20\2\2\u01f8\u01f7\3\2\2\2\u01f8\u01f9\3"+
		"\2\2\2\u01f9\u01fb\3\2\2\2\u01fa\u01fc\5? \2\u01fb\u01fa\3\2\2\2\u01fc"+
		"\u01fd\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0084\3\2"+
		"\2\2\u01ff\u0204\5c\62\2\u0200\u0204\t\21\2\2\u0201\u0204\5? \2\u0202"+
		"\u0204\t\22\2\2\u0203\u01ff\3\2\2\2\u0203\u0200\3\2\2\2\u0203\u0201\3"+
		"\2\2\2\u0203\u0202\3\2\2\2\u0204\u0086\3\2\2\2\u0205\u0206\7p\2\2\u0206"+
		"\u0207\7w\2\2\u0207\u0208\7n\2\2\u0208\u0209\7n\2\2\u0209\u0088\3\2\2"+
		"\2\u020a\u020b\7*\2\2\u020b\u008a\3\2\2\2\u020c\u020d\7+\2\2\u020d\u008c"+
		"\3\2\2\2\u020e\u020f\7}\2\2\u020f\u008e\3\2\2\2\u0210\u0211\7\177\2\2"+
		"\u0211\u0090\3\2\2\2\u0212\u0213\7/\2\2\u0213\u0214\7@\2\2\u0214\u0092"+
		"\3\2\2\2\u0215\u0216\7v\2\2\u0216\u0217\7t\2\2\u0217\u0218\7w\2\2\u0218"+
		"\u021f\7g\2\2\u0219\u021a\7h\2\2\u021a\u021b\7c\2\2\u021b\u021c\7n\2\2"+
		"\u021c\u021d\7u\2\2\u021d\u021f\7g\2\2\u021e\u0215\3\2\2\2\u021e\u0219"+
		"\3\2\2\2\u021f\u0094\3\2\2\2\u0220\u0224\5c\62\2\u0221\u0223\5\u0085C"+
		"\2\u0222\u0221\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225"+
		"\3\2\2\2\u0225\u0096\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u022a\5\177@\2"+
		"\u0228\u022a\5=\37\2\u0229\u0227\3\2\2\2\u0229\u0228\3\2\2\2\u022a\u022b"+
		"\3\2\2\2\u022b\u022c\t\23\2\2\u022c\u0098\3\2\2\2\u022d\u022e\7f\2\2\u022e"+
		"\u022f\7g\2\2\u022f\u0230\7u\2\2\u0230\u0235\7e\2\2\u0231\u0232\7c\2\2"+
		"\u0232\u0233\7u\2\2\u0233\u0235\7e\2\2\u0234\u022d\3\2\2\2\u0234\u0231"+
		"\3\2\2\2\u0235\u009a\3\2\2\2\u0236\u023a\5\u009dO\2\u0237\u023a\5\u00a1"+
		"Q\2\u0238\u023a\5\u009fP\2\u0239\u0236\3\2\2\2\u0239\u0237\3\2\2\2\u0239"+
		"\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\bN\3\2\u023c\u009c\3\2"+
		"\2\2\u023d\u023f\t\24\2\2\u023e\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240"+
		"\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u009e\3\2\2\2\u0242\u0244\7^"+
		"\2\2\u0243\u0245\5\u009dO\2\u0244\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245"+
		"\u024b\3\2\2\2\u0246\u0248\7\17\2\2\u0247\u0246\3\2\2\2\u0247\u0248\3"+
		"\2\2\2\u0248\u0249\3\2\2\2\u0249\u024c\7\f\2\2\u024a\u024c\4\16\17\2\u024b"+
		"\u0247\3\2\2\2\u024b\u024a\3\2\2\2\u024c\u00a0\3\2\2\2\u024d\u024e\7\61"+
		"\2\2\u024e\u024f\7\61\2\2\u024f\u0253\3\2\2\2\u0250\u0252\n\25\2\2\u0251"+
		"\u0250\3\2\2\2\u0252\u0255\3\2\2\2\u0253\u0251\3\2\2\2\u0253\u0254\3\2"+
		"\2\2\u0254\u0262\3\2\2\2\u0255\u0253\3\2\2\2\u0256\u0257\7\61\2\2\u0257"+
		"\u0258\7,\2\2\u0258\u025c\3\2\2\2\u0259\u025b\13\2\2\2\u025a\u0259\3\2"+
		"\2\2\u025b\u025e\3\2\2\2\u025c\u025d\3\2\2\2\u025c\u025a\3\2\2\2\u025d"+
		"\u025f\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0260\7,\2\2\u0260\u0262\7\61"+
		"\2\2\u0261\u024d\3\2\2\2\u0261\u0256\3\2\2\2\u0262\u00a2\3\2\2\2\67\2"+
		"\u00ed\u00f2\u0106\u010b\u0110\u0119\u012e\u0152\u0158\u015b\u0164\u0168"+
		"\u016d\u016f\u0176\u0178\u017c\u0185\u0192\u0198\u019c\u01a2\u01a8\u01aa"+
		"\u01b1\u01bc\u01ca\u01cd\u01d2\u01d8\u01db\u01de\u01e3\u01e8\u01ed\u01ef"+
		"\u01f4\u01f8\u01fd\u0203\u021e\u0224\u0229\u0234\u0239\u0240\u0244\u0247"+
		"\u024b\u0253\u025c\u0261\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}