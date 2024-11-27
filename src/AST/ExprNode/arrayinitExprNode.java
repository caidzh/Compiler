package AST.ExprNode;

import java.util.ArrayList;

import AST.ASTVisitor;
import Util.position;

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
