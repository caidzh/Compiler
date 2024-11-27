package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;

public class nullExprNode extends literalExprNode{
    public nullExprNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
