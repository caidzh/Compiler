package AST.StmtNode;

import java.util.ArrayList;

import AST.ASTVisitor;
import Util.position;

public class suiteStmtNode extends StmtNode{
    public ArrayList<StmtNode> stmts;

    public suiteStmtNode(position pos) {
        super(pos);
        this.stmts = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
