package AST.ExprNode;

import AST.ASTVisitor;
import Util.scope.position;

public class parenExprNode extends ExprNode{
    public ExprNode expr;

    public parenExprNode(ExprNode expr, position pos) {
        super(pos);
        this.expr = expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
