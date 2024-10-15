package AST.ExprNode;

import AST.ASTVisitor;
import Util.scope.position;

public class boolExprNode extends literalExprNode{
    public boolean val;
    public boolExprNode(boolean val,position pos){
        super(pos);
        this.val = val;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
