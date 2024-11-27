package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;

public class intExprNode extends literalExprNode{
    public int val;
    public intExprNode(int val,position pos){
        super(pos);
        this.val = val;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
