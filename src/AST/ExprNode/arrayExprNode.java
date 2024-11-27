package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;

public class arrayExprNode extends ExprNode{
    public ExprNode name,index;

    public arrayExprNode(ExprNode name, ExprNode index, position pos) {
        super(pos);
        this.name = name;
        this.index = index;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
