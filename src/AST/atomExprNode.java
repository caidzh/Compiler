package AST;

import Util.position;

public class atomExprNode extends ExprNode{
    public String str;

    public atomExprNode(String str, position pos) {
        super(pos);
        this.str = str;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
