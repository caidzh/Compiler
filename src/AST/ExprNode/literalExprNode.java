package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;

public abstract class literalExprNode extends ExprNode{
    public literalExprNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
