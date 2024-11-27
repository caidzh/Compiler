package AST.StmtNode;

import AST.ASTVisitor;
import AST.ExprNode.ExprNode;
import Util.position;

public class forStmtNode extends StmtNode{
    public StmtNode initStmt, condition, bodyStmt;
    public ExprNode step;

    public forStmtNode(StmtNode initStmt, StmtNode condition, ExprNode step, StmtNode bodyStmt, position pos) {
        super(pos);
        this.initStmt = initStmt;
        this.condition = condition;
        this.step = step;
        this.bodyStmt = bodyStmt;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
