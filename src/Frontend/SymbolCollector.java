package Frontend;

import AST.*;
import Util.Typeinfo;
import Util.globalScope;

import java.util.HashMap;

public class SymbolCollector implements ASTVisitor {
    private globalScope gScope;
    public SymbolCollector(globalScope gScope) {
        this.gScope = gScope;
    }
    @Override public void visit(RootNode it){
        
    }

    @Override public void visit(funcDefNode it){

    }
    @Override public void visit(classDefNode it){

    }
    @Override public void visit(varDefsNode it){

    }
    @Override public void visit(varDefNode it){

    }

    @Override public void visit(binaryOpExprNode it){}
    @Override public void visit(binaryCmpExprNode it){}
    @Override public void visit(assignExprNode it){}
    @Override public void visit(parenExprNode it){}
    @Override public void visit(arrayExprNode it){}
    @Override public void visit(arrayinitExprNode it){}
    @Override public void visit(newarrayExprNode it){}
    @Override public void visit(newvarExprNode it){}
    @Override public void visit(memberExprNode it){}
    @Override public void visit(rightExprNode it){}
    @Override public void visit(leftExprNode it){}
    @Override public void visit(literalExprNode it){}
    @Override public void visit(atomExprNode it){}
    @Override public void visit(formatstringExprNode it){}
    @Override public void visit(funcExprNode it){}
    @Override public void visit(ternaryExprNode it){}

    @Override public void visit(ifStmtNode it){}
    @Override public void visit(forStmtNode it){}
    @Override public void visit(returnStmtNode it){}
    @Override public void visit(suiteStmtNode it){}
    @Override public void visit(pureExprStmtNode it){}
    @Override public void visit(whileStmtNode it){}
    @Override public void visit(jumpStmtNode it){}
    @Override public void visit(exprStmtNode it){}
}
