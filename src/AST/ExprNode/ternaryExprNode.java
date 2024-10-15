package AST.ExprNode;

import AST.ASTVisitor;
import Util.scope.position;

public class ternaryExprNode extends ExprNode{
    public ExprNode cond, thenstmt, elsestmt;

    public ternaryExprNode(ExprNode cond,ExprNode thenstmt, ExprNode elsestmt, position pos) {
        super(pos);
        this.cond = cond;
        this.thenstmt = thenstmt;
        this.elsestmt = elsestmt;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}