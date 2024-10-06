package AST;

import Util.position;

public class pureExprStmtNode extends StmtNode{
    public ExprNode expr;

    public pureExprStmtNode(ExprNode expr, position pos) {
        super(pos);
        this.expr = expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}