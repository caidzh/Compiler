package AST;

import AST.DefNode.*;
import AST.ExprNode.*;
import AST.StmtNode.*;

public interface ASTVisitor {
    void visit(RootNode it);

    void visit(funcDefNode it);
    void visit(classDefNode it);
    void visit(varDefsNode it);
    void visit(varDefNode it);

    void visit(ExprNode it);
    void visit(binaryOpExprNode it);
    void visit(binaryCmpExprNode it);
    void visit(assignExprNode it);
    void visit(parenExprNode it);
    void visit(arrayExprNode it);
    void visit(arrayinitExprNode it);
    void visit(newarrayExprNode it);
    void visit(newvarExprNode it);
    void visit(memberExprNode it);
    void visit(rightExprNode it);
    void visit(leftExprNode it);
    void visit(literalExprNode it);
    void visit(atomExprNode it);
    void visit(formatstringExprNode it);
    void visit(funcExprNode it);
    void visit(ternaryExprNode it);

    void visit(ifStmtNode it);
    void visit(forStmtNode it);
    void visit(returnStmtNode it);
    void visit(suiteStmtNode it);
    void visit(pureExprStmtNode it);
    void visit(whileStmtNode it);
    void visit(jumpStmtNode it);
    void visit(exprStmtNode it);
    void visit(varDefStmtNode it);
}