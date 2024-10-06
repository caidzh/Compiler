// Generated from ./src/Grammar/Mx.g4 by ANTLR 4.13.2
package Grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expressionlist}.
	 * @param ctx the parse tree
	 */
	void enterExpressionlist(MxParser.ExpressionlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expressionlist}.
	 * @param ctx the parse tree
	 */
	void exitExpressionlist(MxParser.ExpressionlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(MxParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(MxParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(MxParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(MxParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#argvar}.
	 * @param ctx the parse tree
	 */
	void enterArgvar(MxParser.ArgvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#argvar}.
	 * @param ctx the parse tree
	 */
	void exitArgvar(MxParser.ArgvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(MxParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(MxParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(MxParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arrayinitial}.
	 * @param ctx the parse tree
	 */
	void enterArrayinitial(MxParser.ArrayinitialContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arrayinitial}.
	 * @param ctx the parse tree
	 */
	void exitArrayinitial(MxParser.ArrayinitialContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(MxParser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(MxParser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MxParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MxParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#formstr}.
	 * @param ctx the parse tree
	 */
	void enterFormstr(MxParser.FormstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#formstr}.
	 * @param ctx the parse tree
	 */
	void exitFormstr(MxParser.FormstrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayInitExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitExpr(MxParser.ArrayInitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayInitExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitExpr(MxParser.ArrayInitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryCmpExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryCmpExpr(MxParser.BinaryCmpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryCmpExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryCmpExpr(MxParser.BinaryCmpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewVarExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewVarExpr(MxParser.NewVarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewVarExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewVarExpr(MxParser.NewVarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(MxParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(MxParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(MxParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(MxParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewArrayExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExpr(MxParser.NewArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewArrayExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExpr(MxParser.NewArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RightExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRightExpr(MxParser.RightExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RightExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRightExpr(MxParser.RightExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FormatStringExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFormatStringExpr(MxParser.FormatStringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FormatStringExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFormatStringExpr(MxParser.FormatStringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(MxParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(MxParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(MxParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(MxParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LeftExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLeftExpr(MxParser.LeftExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LeftExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLeftExpr(MxParser.LeftExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TernaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(MxParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TernaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(MxParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOpExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOpExpr(MxParser.BinaryOpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOpExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOpExpr(MxParser.BinaryOpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classConstruct}.
	 * @param ctx the parse tree
	 */
	void enterClassConstruct(MxParser.ClassConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classConstruct}.
	 * @param ctx the parse tree
	 */
	void exitClassConstruct(MxParser.ClassConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(MxParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(MxParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suiteStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSuiteStmt(MxParser.SuiteStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suiteStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSuiteStmt(MxParser.SuiteStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDefStmt(MxParser.VarDefStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDefStmt(MxParser.VarDefStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pureExprStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPureExprStmt(MxParser.PureExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pureExprStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPureExprStmt(MxParser.PureExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStmt(MxParser.JumpStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStmt(MxParser.JumpStmtContext ctx);
}