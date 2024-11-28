package AST.StmtNode;

import AST.ASTVisitor;
import Util.position;

public class jumpStmtNode extends StmtNode{
    public enum jumpType {
        Continue, Break
    }
    public jumpType opCode;

    public jumpStmtNode(jumpType opCode, position pos) {
        super(pos);
        this.opCode = opCode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
