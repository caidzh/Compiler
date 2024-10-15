package AST.StmtNode;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.ExprNode.ExprNode;
import Util.scope.position;

public class exprStmtNode extends ASTNode{
    public ExprNode expr;

    public exprStmtNode(ExprNode expr,position pos) {
        super(pos);
        this.expr = expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}