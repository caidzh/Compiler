package AST.StmtNode;

import AST.ASTVisitor;
import AST.ExprNode.ExprNode;
import Util.position;

public class returnStmtNode extends StmtNode {
    public ExprNode value;

    public returnStmtNode(ExprNode value, position pos) {
        super(pos);
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
