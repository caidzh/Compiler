package AST;

import AST.DefNode.classDefNode;
import AST.DefNode.funcDefNode;
import AST.DefNode.varDefNode;
import AST.DefNode.varDefsNode;
import AST.ExprNode.arrayExprNode;
import AST.ExprNode.arrayinitExprNode;
import AST.ExprNode.assignExprNode;
import AST.ExprNode.atomExprNode;
import AST.ExprNode.binaryCmpExprNode;
import AST.ExprNode.binaryOpExprNode;
import AST.ExprNode.formatstringExprNode;
import AST.ExprNode.funcExprNode;
import AST.ExprNode.leftExprNode;
import AST.ExprNode.literalExprNode;
import AST.ExprNode.memberExprNode;
import AST.ExprNode.newarrayExprNode;
import AST.ExprNode.newvarExprNode;
import AST.ExprNode.parenExprNode;
import AST.ExprNode.rightExprNode;
import AST.ExprNode.ternaryExprNode;
import AST.StmtNode.exprStmtNode;
import AST.StmtNode.forStmtNode;
import AST.StmtNode.ifStmtNode;
import AST.StmtNode.jumpStmtNode;
import AST.StmtNode.pureExprStmtNode;
import AST.StmtNode.returnStmtNode;
import AST.StmtNode.suiteStmtNode;
import AST.StmtNode.whileStmtNode;

public interface ASTVisitor {
    void visit(RootNode it);

    void visit(funcDefNode it);
    void visit(classDefNode it);
    void visit(varDefsNode it);
    void visit(varDefNode it);

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
}