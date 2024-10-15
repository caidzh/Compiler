package AST.DefNode;

import Util.scope.position;

import java.util.ArrayList;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.StmtNode.suiteStmtNode;

public class classDefNode extends ASTNode{
    public String name;
    public ArrayList<DefNode> Defs = new ArrayList<>();
    public suiteStmtNode constructor;

    public classDefNode(position pos, String name){
        super(pos);
        this.name=name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
