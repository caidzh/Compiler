package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;

public class conststrExprNode extends literalExprNode{
    public String val;
    public conststrExprNode(String val,position pos){
        super(pos);
        this.val = val;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
