package AST.StmtNode;

import AST.ASTVisitor;
import AST.ExprNode.ExprNode;
import Util.scope.position;

public class whileStmtNode extends StmtNode{
    public StmtNode bodyStmt;
    public ExprNode condition;

    public whileStmtNode(ExprNode condition, StmtNode bodyStmt, position pos) {
        super(pos);
        this.condition = condition;
        this.bodyStmt = bodyStmt;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
