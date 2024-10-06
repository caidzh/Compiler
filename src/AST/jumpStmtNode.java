package AST;

import Util.position;

public class jumpStmtNode extends StmtNode{
    public ExprNode value;
    public enum jumpType {
        Continue, Break, Return
    }
    public jumpType opCode;

    public jumpStmtNode(ExprNode value, jumpType opCode, position pos) {
        super(pos);
        this.value = value;
        this.opCode = opCode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
