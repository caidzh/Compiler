// Generated from /home/dzh/Compiler/src/Grammar/Mx.g4 by ANTLR 4.13.1
package Grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Add=1, Sub=2, Mul=3, Div=4, Mod=5, Ge=6, Le=7, Geq=8, Leq=9, Neq=10, Eq=11, 
		And=12, Or=13, Not=14, RightShift=15, LeftShift=16, BitAnd=17, BitOr=18, 
		BitXor=19, BitNot=20, Assign=21, Inc=22, Dec=23, Dot=24, LeftParen=25, 
		RightParen=26, LeftBracket=27, RightBracket=28, LeftBrace=29, RightBrace=30, 
		Question=31, Colon=32, Semi=33, Comma=34, Void=35, Bool=36, Int=37, String=38, 
		New=39, Class=40, Null=41, True=42, False=43, This=44, If=45, Else=46, 
		For=47, While=48, Break=49, Continue=50, Return=51, Identifier=52, DecimalInteger=53, 
		ConstString=54, FormatString=55, FormatStringL=56, FormatStringM=57, FormatStringR=58, 
		Whitespace=59, Newline=60, BlockComment=61, LineComment=62;
	public static final int
		RULE_program = 0, RULE_expressionlist = 1, RULE_funcDef = 2, RULE_arglist = 3, 
		RULE_arg = 4, RULE_argvar = 5, RULE_varDef = 6, RULE_array = 7, RULE_arrayinitial = 8, 
		RULE_typename = 9, RULE_type = 10, RULE_literal = 11, RULE_formstr = 12, 
		RULE_expression = 13, RULE_classDef = 14, RULE_classConstruct = 15, RULE_suite = 16, 
		RULE_statement = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expressionlist", "funcDef", "arglist", "arg", "argvar", "varDef", 
			"array", "arrayinitial", "typename", "type", "literal", "formstr", "expression", 
			"classDef", "classConstruct", "suite", "statement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'>'", "'<'", "'>='", "'<='", 
			"'!='", "'=='", "'&&'", "'||'", "'!'", "'>>'", "'<<'", "'&'", "'|'", 
			"'^'", "'~'", "'='", "'++'", "'--'", "'.'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'?'", "':'", "';'", "','", "'void'", "'bool'", "'int'", 
			"'string'", "'new'", "'class'", "'null'", "'true'", "'false'", "'this'", 
			"'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Add", "Sub", "Mul", "Div", "Mod", "Ge", "Le", "Geq", "Leq", "Neq", 
			"Eq", "And", "Or", "Not", "RightShift", "LeftShift", "BitAnd", "BitOr", 
			"BitXor", "BitNot", "Assign", "Inc", "Dec", "Dot", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Question", 
			"Colon", "Semi", "Comma", "Void", "Bool", "Int", "String", "New", "Class", 
			"Null", "True", "False", "This", "If", "Else", "For", "While", "Break", 
			"Continue", "Return", "Identifier", "DecimalInteger", "ConstString", 
			"FormatString", "FormatStringL", "FormatStringM", "FormatStringR", "Whitespace", 
			"Newline", "BlockComment", "LineComment"
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
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4505214535073792L) != 0)) {
				{
				setState(39);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36);
					classDef();
					}
					break;
				case 2:
					{
					setState(37);
					varDef();
					}
					break;
				case 3:
					{
					setState(38);
					funcDef();
					}
					break;
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionlistContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public ExpressionlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionlist; }
	}

	public final ExpressionlistContext expressionlist() throws RecognitionException {
		ExpressionlistContext _localctx = new ExpressionlistContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expressionlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			expression(0);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(47);
				match(Comma);
				setState(48);
				expression(0);
				}
				}
				setState(53);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public Token name;
		public SuiteContext body;
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			typename();
			setState(55);
			((FuncDefContext)_localctx).name = match(Identifier);
			setState(56);
			match(LeftParen);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504115023446016L) != 0)) {
				{
				setState(57);
				arglist();
				}
			}

			setState(60);
			match(RightParen);
			setState(61);
			((FuncDefContext)_localctx).body = suite();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArglistContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arglist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			arg();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(64);
				match(Comma);
				setState(65);
				arg();
				}
				}
				setState(70);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public ArgvarContext argvar() {
			return getRuleContext(ArgvarContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			typename();
			setState(72);
			argvar();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgvarContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argvar; }
	}

	public final ArgvarContext argvar() throws RecognitionException {
		ArgvarContext _localctx = new ArgvarContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_argvar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			((ArgvarContext)_localctx).name = match(Identifier);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(75);
				match(Assign);
				setState(76);
				expression(0);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public List<ArgvarContext> argvar() {
			return getRuleContexts(ArgvarContext.class);
		}
		public ArgvarContext argvar(int i) {
			return getRuleContext(ArgvarContext.class,i);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			typename();
			setState(80);
			argvar();
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(81);
					match(Comma);
					setState(82);
					argvar();
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(88);
			match(Semi);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(LeftBracket);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139645124137205764L) != 0)) {
				{
				setState(91);
				expression(0);
				}
			}

			setState(94);
			match(RightBracket);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayinitialContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public ExpressionlistContext expressionlist() {
			return getRuleContext(ExpressionlistContext.class,0);
		}
		public ArrayinitialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayinitial; }
	}

	public final ArrayinitialContext arrayinitial() throws RecognitionException {
		ArrayinitialContext _localctx = new ArrayinitialContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayinitial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(LeftBrace);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139645124137205764L) != 0)) {
				{
				setState(97);
				expressionlist();
				}
			}

			setState(100);
			match(RightBrace);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypenameContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typename);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			type();
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(103);
					match(LeftBracket);
					setState(104);
					match(RightBracket);
					}
					} 
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode String() { return getToken(MxParser.String, 0); }
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504115023446016L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode False() { return getToken(MxParser.False, 0); }
		public TerminalNode True() { return getToken(MxParser.True, 0); }
		public TerminalNode Null() { return getToken(MxParser.Null, 0); }
		public TerminalNode ConstString() { return getToken(MxParser.ConstString, 0); }
		public TerminalNode DecimalInteger() { return getToken(MxParser.DecimalInteger, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 27036990927011840L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormstrContext extends ParserRuleContext {
		public TerminalNode FormatString() { return getToken(MxParser.FormatString, 0); }
		public TerminalNode FormatStringL() { return getToken(MxParser.FormatStringL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FormatStringR() { return getToken(MxParser.FormatStringR, 0); }
		public TerminalNode FormatStringM() { return getToken(MxParser.FormatStringM, 0); }
		public FormstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formstr; }
	}

	public final FormstrContext formstr() throws RecognitionException {
		FormstrContext _localctx = new FormstrContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_formstr);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FormatString:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(FormatString);
				}
				break;
			case FormatStringL:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(115);
				match(FormatStringL);
				setState(116);
				expression(0);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FormatStringM) {
					{
					setState(117);
					match(FormatStringM);
					setState(118);
					expression(0);
					}
				}

				setState(121);
				match(FormatStringR);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInitExprContext extends ExpressionContext {
		public ArrayinitialContext arrayinitial() {
			return getRuleContext(ArrayinitialContext.class,0);
		}
		public ArrayInitExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryCmpExprContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Ge() { return getToken(MxParser.Ge, 0); }
		public TerminalNode Le() { return getToken(MxParser.Le, 0); }
		public TerminalNode Geq() { return getToken(MxParser.Geq, 0); }
		public TerminalNode Leq() { return getToken(MxParser.Leq, 0); }
		public TerminalNode Neq() { return getToken(MxParser.Neq, 0); }
		public TerminalNode Eq() { return getToken(MxParser.Eq, 0); }
		public BinaryCmpExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public AtomExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewVarExprContext extends ExpressionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public NewVarExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionlistContext expressionlist() {
			return getRuleContext(ExpressionlistContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public FuncExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignExprContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayExprContext extends ExpressionContext {
		public ExpressionContext name;
		public ExpressionContext index;
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewArrayExprContext extends ExpressionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
		}
		public ArrayinitialContext arrayinitial() {
			return getRuleContext(ArrayinitialContext.class,0);
		}
		public NewArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public MemberExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RightExprContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Inc() { return getToken(MxParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(MxParser.Dec, 0); }
		public RightExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FormatStringExprContext extends ExpressionContext {
		public FormstrContext formstr() {
			return getRuleContext(FormstrContext.class,0);
		}
		public FormatStringExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExprContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExpressionContext {
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext rhs;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Inc() { return getToken(MxParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(MxParser.Dec, 0); }
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
		public TerminalNode BitNot() { return getToken(MxParser.BitNot, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public LeftExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryExprContext extends ExpressionContext {
		public ExpressionContext cond;
		public ExpressionContext thenstmt;
		public ExpressionContext elsestmt;
		public TerminalNode Question() { return getToken(MxParser.Question, 0); }
		public TerminalNode Colon() { return getToken(MxParser.Colon, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOpExprContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public TerminalNode RightShift() { return getToken(MxParser.RightShift, 0); }
		public TerminalNode LeftShift() { return getToken(MxParser.LeftShift, 0); }
		public TerminalNode BitAnd() { return getToken(MxParser.BitAnd, 0); }
		public TerminalNode BitXor() { return getToken(MxParser.BitXor, 0); }
		public TerminalNode BitOr() { return getToken(MxParser.BitOr, 0); }
		public TerminalNode And() { return getToken(MxParser.And, 0); }
		public TerminalNode Or() { return getToken(MxParser.Or, 0); }
		public BinaryOpExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(126);
				match(LeftParen);
				setState(127);
				expression(0);
				setState(128);
				match(RightParen);
				}
				break;
			case 2:
				{
				_localctx = new NewArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				match(New);
				setState(131);
				type();
				setState(133); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(132);
						array();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(135); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(137);
					arrayinitial();
					}
					break;
				}
				}
				break;
			case 3:
				{
				_localctx = new NewVarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(New);
				setState(141);
				type();
				setState(144);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(142);
					match(LeftParen);
					setState(143);
					match(RightParen);
					}
					break;
				}
				}
				break;
			case 4:
				{
				_localctx = new LeftExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				((LeftExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
					((LeftExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(147);
				((LeftExprContext)_localctx).rhs = expression(19);
				}
				break;
			case 5:
				{
				_localctx = new LeftExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				((LeftExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1064964L) != 0)) ) {
					((LeftExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(149);
				((LeftExprContext)_localctx).rhs = expression(18);
				}
				break;
			case 6:
				{
				_localctx = new ArrayInitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				arrayinitial();
				}
				break;
			case 7:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				literal();
				}
				break;
			case 8:
				{
				_localctx = new FormatStringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				formstr();
				}
				break;
			case 9:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(Identifier);
				}
				break;
			case 10:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(This);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(211);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(158);
						((BinaryOpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0)) ) {
							((BinaryOpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(159);
						((BinaryOpExprContext)_localctx).rhs = expression(18);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(160);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(161);
						((BinaryOpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((BinaryOpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(162);
						((BinaryOpExprContext)_localctx).rhs = expression(17);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(163);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(164);
						((BinaryOpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==RightShift || _la==LeftShift) ) {
							((BinaryOpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(165);
						((BinaryOpExprContext)_localctx).rhs = expression(16);
						}
						break;
					case 4:
						{
						_localctx = new BinaryCmpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryCmpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(166);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(167);
						((BinaryCmpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 960L) != 0)) ) {
							((BinaryCmpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(168);
						((BinaryCmpExprContext)_localctx).rhs = expression(15);
						}
						break;
					case 5:
						{
						_localctx = new BinaryCmpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryCmpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(170);
						((BinaryCmpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Neq || _la==Eq) ) {
							((BinaryCmpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(171);
						((BinaryCmpExprContext)_localctx).rhs = expression(14);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(172);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(173);
						((BinaryOpExprContext)_localctx).op = match(BitAnd);
						setState(174);
						((BinaryOpExprContext)_localctx).rhs = expression(13);
						}
						break;
					case 7:
						{
						_localctx = new BinaryOpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(175);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(176);
						((BinaryOpExprContext)_localctx).op = match(BitXor);
						setState(177);
						((BinaryOpExprContext)_localctx).rhs = expression(12);
						}
						break;
					case 8:
						{
						_localctx = new BinaryOpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(178);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(179);
						((BinaryOpExprContext)_localctx).op = match(BitOr);
						setState(180);
						((BinaryOpExprContext)_localctx).rhs = expression(11);
						}
						break;
					case 9:
						{
						_localctx = new BinaryOpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(181);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(182);
						((BinaryOpExprContext)_localctx).op = match(And);
						setState(183);
						((BinaryOpExprContext)_localctx).rhs = expression(10);
						}
						break;
					case 10:
						{
						_localctx = new BinaryOpExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryOpExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(184);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(185);
						((BinaryOpExprContext)_localctx).op = match(Or);
						setState(186);
						((BinaryOpExprContext)_localctx).rhs = expression(9);
						}
						break;
					case 11:
						{
						_localctx = new TernaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((TernaryExprContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(187);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(188);
						match(Question);
						setState(189);
						((TernaryExprContext)_localctx).thenstmt = expression(0);
						setState(190);
						match(Colon);
						setState(191);
						((TernaryExprContext)_localctx).elsestmt = expression(7);
						}
						break;
					case 12:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						((AssignExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(193);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(194);
						((AssignExprContext)_localctx).op = match(Assign);
						setState(195);
						((AssignExprContext)_localctx).rhs = expression(6);
						}
						break;
					case 13:
						{
						_localctx = new ArrayExprContext(new ExpressionContext(_parentctx, _parentState));
						((ArrayExprContext)_localctx).name = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(197);
						match(LeftBracket);
						setState(198);
						((ArrayExprContext)_localctx).index = expression(0);
						setState(199);
						match(RightBracket);
						}
						break;
					case 14:
						{
						_localctx = new MemberExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(202);
						match(Dot);
						setState(203);
						match(Identifier);
						}
						break;
					case 15:
						{
						_localctx = new FuncExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(205);
						match(LeftParen);
						setState(206);
						expressionlist();
						setState(207);
						match(RightParen);
						}
						break;
					case 16:
						{
						_localctx = new RightExprContext(new ExpressionContext(_parentctx, _parentState));
						((RightExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(210);
						((RightExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Inc || _la==Dec) ) {
							((RightExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(215);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ClassConstructContext> classConstruct() {
			return getRuleContexts(ClassConstructContext.class);
		}
		public ClassConstructContext classConstruct(int i) {
			return getRuleContext(ClassConstructContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(Class);
			setState(217);
			match(Identifier);
			setState(218);
			match(LeftBrace);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504115023446016L) != 0)) {
				{
				setState(222);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(219);
					varDef();
					}
					break;
				case 2:
					{
					setState(220);
					funcDef();
					}
					break;
				case 3:
					{
					setState(221);
					classConstruct();
					}
					break;
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(RightBrace);
			setState(228);
			match(Semi);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassConstructContext extends ParserRuleContext {
		public Token name;
		public SuiteContext body;
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ClassConstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classConstruct; }
	}

	public final ClassConstructContext classConstruct() throws RecognitionException {
		ClassConstructContext _localctx = new ClassConstructContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_classConstruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			((ClassConstructContext)_localctx).name = match(Identifier);
			setState(231);
			match(LeftParen);
			setState(232);
			match(RightParen);
			setState(233);
			((ClassConstructContext)_localctx).body = suite();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(LeftBrace);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 144043694634319876L) != 0)) {
				{
				{
				setState(236);
				statement();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
			match(RightBrace);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JumpStmtContext extends StatementContext {
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public JumpStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDefStmtContext extends StatementContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarDefStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends StatementContext {
		public StatementContext init;
		public StatementContext cond;
		public ExpressionContext step;
		public StatementContext body;
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends StatementContext {
		public ExpressionContext cond;
		public StatementContext body;
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends StatementContext {
		public ExpressionContext cond;
		public StatementContext thenstmt;
		public StatementContext elsestmt;
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
		public IfStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStmtContext extends StatementContext {
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public EmptyStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StatementContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SuiteStmtContext extends StatementContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public SuiteStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PureExprStmtContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public PureExprStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		int _la;
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new SuiteStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				suite();
				}
				break;
			case 2:
				_localctx = new VarDefStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				varDef();
				}
				break;
			case 3:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(If);
				setState(247);
				match(LeftParen);
				setState(248);
				((IfStmtContext)_localctx).cond = expression(0);
				setState(249);
				match(RightParen);
				setState(250);
				((IfStmtContext)_localctx).thenstmt = statement();
				setState(253);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(251);
					match(Else);
					setState(252);
					((IfStmtContext)_localctx).elsestmt = statement();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(255);
				match(Return);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139645124137205764L) != 0)) {
					{
					setState(256);
					expression(0);
					}
				}

				setState(259);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new PureExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				expression(0);
				setState(261);
				match(Semi);
				}
				break;
			case 6:
				_localctx = new EmptyStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(263);
				match(Semi);
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(264);
				match(For);
				setState(265);
				match(LeftParen);
				setState(266);
				((ForStmtContext)_localctx).init = statement();
				setState(267);
				((ForStmtContext)_localctx).cond = statement();
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139645124137205764L) != 0)) {
					{
					setState(268);
					((ForStmtContext)_localctx).step = expression(0);
					}
				}

				setState(271);
				match(RightParen);
				setState(272);
				((ForStmtContext)_localctx).body = statement();
				}
				break;
			case 8:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(274);
				match(While);
				setState(275);
				match(LeftParen);
				setState(276);
				((WhileStmtContext)_localctx).cond = expression(0);
				setState(277);
				match(RightParen);
				setState(278);
				((WhileStmtContext)_localctx).body = statement();
				}
				break;
			case 9:
				_localctx = new JumpStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(280);
				_la = _input.LA(1);
				if ( !(_la==Break || _la==Continue) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(281);
				match(Semi);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 7);
		case 11:
			return precpred(_ctx, 6);
		case 12:
			return precpred(_ctx, 25);
		case 13:
			return precpred(_ctx, 22);
		case 14:
			return precpred(_ctx, 21);
		case 15:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001>\u011d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00012\b\u0001"+
		"\n\u0001\f\u00015\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002;\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003C\b\u0003\n\u0003\f\u0003F\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005N\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006T\b\u0006\n\u0006\f\u0006W\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0003\u0007]\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0003\bc\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0005\tj\b\t\n\t\f\tm\t\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\fx\b\f\u0001\f\u0001\f\u0003"+
		"\f|\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0004\r\u0086\b\r\u000b\r\f\r\u0087\u0001\r\u0003\r\u008b\b\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u0091\b\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u009c\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00d4"+
		"\b\r\n\r\f\r\u00d7\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u00df\b\u000e\n\u000e\f\u000e\u00e2"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u00ee"+
		"\b\u0010\n\u0010\f\u0010\u00f1\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u00fe\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0102\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u010e\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u011b\b\u0011\u0001\u0011\u0002Uk\u0001\u001a"+
		"\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"\u0000\n\u0002\u0000#&44\u0002\u0000)+56\u0001\u0000"+
		"\u0016\u0017\u0003\u0000\u0002\u0002\u000e\u000e\u0014\u0014\u0001\u0000"+
		"\u0003\u0005\u0001\u0000\u0001\u0002\u0001\u0000\u000f\u0010\u0001\u0000"+
		"\u0006\t\u0001\u0000\n\u000b\u0001\u000012\u0142\u0000)\u0001\u0000\u0000"+
		"\u0000\u0002.\u0001\u0000\u0000\u0000\u00046\u0001\u0000\u0000\u0000\u0006"+
		"?\u0001\u0000\u0000\u0000\bG\u0001\u0000\u0000\u0000\nJ\u0001\u0000\u0000"+
		"\u0000\fO\u0001\u0000\u0000\u0000\u000eZ\u0001\u0000\u0000\u0000\u0010"+
		"`\u0001\u0000\u0000\u0000\u0012f\u0001\u0000\u0000\u0000\u0014n\u0001"+
		"\u0000\u0000\u0000\u0016p\u0001\u0000\u0000\u0000\u0018{\u0001\u0000\u0000"+
		"\u0000\u001a\u009b\u0001\u0000\u0000\u0000\u001c\u00d8\u0001\u0000\u0000"+
		"\u0000\u001e\u00e6\u0001\u0000\u0000\u0000 \u00eb\u0001\u0000\u0000\u0000"+
		"\"\u011a\u0001\u0000\u0000\u0000$(\u0003\u001c\u000e\u0000%(\u0003\f\u0006"+
		"\u0000&(\u0003\u0004\u0002\u0000\'$\u0001\u0000\u0000\u0000\'%\u0001\u0000"+
		"\u0000\u0000\'&\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001"+
		"\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000"+
		"+)\u0001\u0000\u0000\u0000,-\u0005\u0000\u0000\u0001-\u0001\u0001\u0000"+
		"\u0000\u0000.3\u0003\u001a\r\u0000/0\u0005\"\u0000\u000002\u0003\u001a"+
		"\r\u00001/\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u00004\u0003\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000067\u0003\u0012\t\u000078\u00054\u0000\u0000"+
		"8:\u0005\u0019\u0000\u00009;\u0003\u0006\u0003\u0000:9\u0001\u0000\u0000"+
		"\u0000:;\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0005\u001a"+
		"\u0000\u0000=>\u0003 \u0010\u0000>\u0005\u0001\u0000\u0000\u0000?D\u0003"+
		"\b\u0004\u0000@A\u0005\"\u0000\u0000AC\u0003\b\u0004\u0000B@\u0001\u0000"+
		"\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000E\u0007\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000"+
		"\u0000GH\u0003\u0012\t\u0000HI\u0003\n\u0005\u0000I\t\u0001\u0000\u0000"+
		"\u0000JM\u00054\u0000\u0000KL\u0005\u0015\u0000\u0000LN\u0003\u001a\r"+
		"\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u000b\u0001"+
		"\u0000\u0000\u0000OP\u0003\u0012\t\u0000PU\u0003\n\u0005\u0000QR\u0005"+
		"\"\u0000\u0000RT\u0003\n\u0005\u0000SQ\u0001\u0000\u0000\u0000TW\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0005!\u0000\u0000"+
		"Y\r\u0001\u0000\u0000\u0000Z\\\u0005\u001b\u0000\u0000[]\u0003\u001a\r"+
		"\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^_\u0005\u001c\u0000\u0000_\u000f\u0001\u0000\u0000\u0000"+
		"`b\u0005\u001d\u0000\u0000ac\u0003\u0002\u0001\u0000ba\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0005\u001e"+
		"\u0000\u0000e\u0011\u0001\u0000\u0000\u0000fk\u0003\u0014\n\u0000gh\u0005"+
		"\u001b\u0000\u0000hj\u0005\u001c\u0000\u0000ig\u0001\u0000\u0000\u0000"+
		"jm\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000l\u0013\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0007"+
		"\u0000\u0000\u0000o\u0015\u0001\u0000\u0000\u0000pq\u0007\u0001\u0000"+
		"\u0000q\u0017\u0001\u0000\u0000\u0000r|\u00057\u0000\u0000st\u00058\u0000"+
		"\u0000tw\u0003\u001a\r\u0000uv\u00059\u0000\u0000vx\u0003\u001a\r\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000yz\u0005:\u0000\u0000z|\u0001\u0000\u0000\u0000{r\u0001\u0000\u0000"+
		"\u0000{s\u0001\u0000\u0000\u0000|\u0019\u0001\u0000\u0000\u0000}~\u0006"+
		"\r\uffff\uffff\u0000~\u007f\u0005\u0019\u0000\u0000\u007f\u0080\u0003"+
		"\u001a\r\u0000\u0080\u0081\u0005\u001a\u0000\u0000\u0081\u009c\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0005\'\u0000\u0000\u0083\u0085\u0003\u0014\n"+
		"\u0000\u0084\u0086\u0003\u000e\u0007\u0000\u0085\u0084\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a\u0001\u0000\u0000"+
		"\u0000\u0089\u008b\u0003\u0010\b\u0000\u008a\u0089\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u009c\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005\'\u0000\u0000\u008d\u0090\u0003\u0014\n\u0000\u008e"+
		"\u008f\u0005\u0019\u0000\u0000\u008f\u0091\u0005\u001a\u0000\u0000\u0090"+
		"\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091"+
		"\u009c\u0001\u0000\u0000\u0000\u0092\u0093\u0007\u0002\u0000\u0000\u0093"+
		"\u009c\u0003\u001a\r\u0013\u0094\u0095\u0007\u0003\u0000\u0000\u0095\u009c"+
		"\u0003\u001a\r\u0012\u0096\u009c\u0003\u0010\b\u0000\u0097\u009c\u0003"+
		"\u0016\u000b\u0000\u0098\u009c\u0003\u0018\f\u0000\u0099\u009c\u00054"+
		"\u0000\u0000\u009a\u009c\u0005,\u0000\u0000\u009b}\u0001\u0000\u0000\u0000"+
		"\u009b\u0082\u0001\u0000\u0000\u0000\u009b\u008c\u0001\u0000\u0000\u0000"+
		"\u009b\u0092\u0001\u0000\u0000\u0000\u009b\u0094\u0001\u0000\u0000\u0000"+
		"\u009b\u0096\u0001\u0000\u0000\u0000\u009b\u0097\u0001\u0000\u0000\u0000"+
		"\u009b\u0098\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u00d5\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\n\u0011\u0000\u0000\u009e\u009f\u0007\u0004\u0000\u0000\u009f"+
		"\u00d4\u0003\u001a\r\u0012\u00a0\u00a1\n\u0010\u0000\u0000\u00a1\u00a2"+
		"\u0007\u0005\u0000\u0000\u00a2\u00d4\u0003\u001a\r\u0011\u00a3\u00a4\n"+
		"\u000f\u0000\u0000\u00a4\u00a5\u0007\u0006\u0000\u0000\u00a5\u00d4\u0003"+
		"\u001a\r\u0010\u00a6\u00a7\n\u000e\u0000\u0000\u00a7\u00a8\u0007\u0007"+
		"\u0000\u0000\u00a8\u00d4\u0003\u001a\r\u000f\u00a9\u00aa\n\r\u0000\u0000"+
		"\u00aa\u00ab\u0007\b\u0000\u0000\u00ab\u00d4\u0003\u001a\r\u000e\u00ac"+
		"\u00ad\n\f\u0000\u0000\u00ad\u00ae\u0005\u0011\u0000\u0000\u00ae\u00d4"+
		"\u0003\u001a\r\r\u00af\u00b0\n\u000b\u0000\u0000\u00b0\u00b1\u0005\u0013"+
		"\u0000\u0000\u00b1\u00d4\u0003\u001a\r\f\u00b2\u00b3\n\n\u0000\u0000\u00b3"+
		"\u00b4\u0005\u0012\u0000\u0000\u00b4\u00d4\u0003\u001a\r\u000b\u00b5\u00b6"+
		"\n\t\u0000\u0000\u00b6\u00b7\u0005\f\u0000\u0000\u00b7\u00d4\u0003\u001a"+
		"\r\n\u00b8\u00b9\n\b\u0000\u0000\u00b9\u00ba\u0005\r\u0000\u0000\u00ba"+
		"\u00d4\u0003\u001a\r\t\u00bb\u00bc\n\u0007\u0000\u0000\u00bc\u00bd\u0005"+
		"\u001f\u0000\u0000\u00bd\u00be\u0003\u001a\r\u0000\u00be\u00bf\u0005 "+
		"\u0000\u0000\u00bf\u00c0\u0003\u001a\r\u0007\u00c0\u00d4\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\n\u0006\u0000\u0000\u00c2\u00c3\u0005\u0015\u0000\u0000"+
		"\u00c3\u00d4\u0003\u001a\r\u0006\u00c4\u00c5\n\u0019\u0000\u0000\u00c5"+
		"\u00c6\u0005\u001b\u0000\u0000\u00c6\u00c7\u0003\u001a\r\u0000\u00c7\u00c8"+
		"\u0005\u001c\u0000\u0000\u00c8\u00d4\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\n\u0016\u0000\u0000\u00ca\u00cb\u0005\u0018\u0000\u0000\u00cb\u00d4\u0005"+
		"4\u0000\u0000\u00cc\u00cd\n\u0015\u0000\u0000\u00cd\u00ce\u0005\u0019"+
		"\u0000\u0000\u00ce\u00cf\u0003\u0002\u0001\u0000\u00cf\u00d0\u0005\u001a"+
		"\u0000\u0000\u00d0\u00d4\u0001\u0000\u0000\u0000\u00d1\u00d2\n\u0014\u0000"+
		"\u0000\u00d2\u00d4\u0007\u0002\u0000\u0000\u00d3\u009d\u0001\u0000\u0000"+
		"\u0000\u00d3\u00a0\u0001\u0000\u0000\u0000\u00d3\u00a3\u0001\u0000\u0000"+
		"\u0000\u00d3\u00a6\u0001\u0000\u0000\u0000\u00d3\u00a9\u0001\u0000\u0000"+
		"\u0000\u00d3\u00ac\u0001\u0000\u0000\u0000\u00d3\u00af\u0001\u0000\u0000"+
		"\u0000\u00d3\u00b2\u0001\u0000\u0000\u0000\u00d3\u00b5\u0001\u0000\u0000"+
		"\u0000\u00d3\u00b8\u0001\u0000\u0000\u0000\u00d3\u00bb\u0001\u0000\u0000"+
		"\u0000\u00d3\u00c1\u0001\u0000\u0000\u0000\u00d3\u00c4\u0001\u0000\u0000"+
		"\u0000\u00d3\u00c9\u0001\u0000\u0000\u0000\u00d3\u00cc\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d6\u001b\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0005(\u0000\u0000\u00d9\u00da\u00054\u0000\u0000\u00da"+
		"\u00e0\u0005\u001d\u0000\u0000\u00db\u00df\u0003\f\u0006\u0000\u00dc\u00df"+
		"\u0003\u0004\u0002\u0000\u00dd\u00df\u0003\u001e\u000f\u0000\u00de\u00db"+
		"\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0005\u001e\u0000\u0000\u00e4\u00e5\u0005!\u0000\u0000\u00e5\u001d\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u00054\u0000\u0000\u00e7\u00e8\u0005\u0019"+
		"\u0000\u0000\u00e8\u00e9\u0005\u001a\u0000\u0000\u00e9\u00ea\u0003 \u0010"+
		"\u0000\u00ea\u001f\u0001\u0000\u0000\u0000\u00eb\u00ef\u0005\u001d\u0000"+
		"\u0000\u00ec\u00ee\u0003\"\u0011\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\u001e\u0000\u0000"+
		"\u00f3!\u0001\u0000\u0000\u0000\u00f4\u011b\u0003 \u0010\u0000\u00f5\u011b"+
		"\u0003\f\u0006\u0000\u00f6\u00f7\u0005-\u0000\u0000\u00f7\u00f8\u0005"+
		"\u0019\u0000\u0000\u00f8\u00f9\u0003\u001a\r\u0000\u00f9\u00fa\u0005\u001a"+
		"\u0000\u0000\u00fa\u00fd\u0003\"\u0011\u0000\u00fb\u00fc\u0005.\u0000"+
		"\u0000\u00fc\u00fe\u0003\"\u0011\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u011b\u0001\u0000\u0000\u0000"+
		"\u00ff\u0101\u00053\u0000\u0000\u0100\u0102\u0003\u001a\r\u0000\u0101"+
		"\u0100\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0001\u0000\u0000\u0000\u0103\u011b\u0005!\u0000\u0000\u0104\u0105"+
		"\u0003\u001a\r\u0000\u0105\u0106\u0005!\u0000\u0000\u0106\u011b\u0001"+
		"\u0000\u0000\u0000\u0107\u011b\u0005!\u0000\u0000\u0108\u0109\u0005/\u0000"+
		"\u0000\u0109\u010a\u0005\u0019\u0000\u0000\u010a\u010b\u0003\"\u0011\u0000"+
		"\u010b\u010d\u0003\"\u0011\u0000\u010c\u010e\u0003\u001a\r\u0000\u010d"+
		"\u010c\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0001\u0000\u0000\u0000\u010f\u0110\u0005\u001a\u0000\u0000\u0110"+
		"\u0111\u0003\"\u0011\u0000\u0111\u011b\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u00050\u0000\u0000\u0113\u0114\u0005\u0019\u0000\u0000\u0114\u0115\u0003"+
		"\u001a\r\u0000\u0115\u0116\u0005\u001a\u0000\u0000\u0116\u0117\u0003\""+
		"\u0011\u0000\u0117\u011b\u0001\u0000\u0000\u0000\u0118\u0119\u0007\t\u0000"+
		"\u0000\u0119\u011b\u0005!\u0000\u0000\u011a\u00f4\u0001\u0000\u0000\u0000"+
		"\u011a\u00f5\u0001\u0000\u0000\u0000\u011a\u00f6\u0001\u0000\u0000\u0000"+
		"\u011a\u00ff\u0001\u0000\u0000\u0000\u011a\u0104\u0001\u0000\u0000\u0000"+
		"\u011a\u0107\u0001\u0000\u0000\u0000\u011a\u0108\u0001\u0000\u0000\u0000"+
		"\u011a\u0112\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000"+
		"\u011b#\u0001\u0000\u0000\u0000\u0019\')3:DMU\\bkw{\u0087\u008a\u0090"+
		"\u009b\u00d3\u00d5\u00de\u00e0\u00ef\u00fd\u0101\u010d\u011a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}