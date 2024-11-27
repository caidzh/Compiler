package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;

public class memberExprNode extends ExprNode{
    public ExprNode name;
    public String Identifier;

    public memberExprNode(ExprNode name, String Identifier, position pos) {
        super(pos);
        this.name = name;
        this.Identifier = Identifier;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
