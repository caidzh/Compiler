package AST;

import Util.position;

import java.util.ArrayList;

public class arrayinitExprNode extends ExprNode{
    public ArrayList<ExprNode> arrayinits = new ArrayList<>();

    public arrayinitExprNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
