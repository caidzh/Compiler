package AST.ExprNode;

import java.util.ArrayList;

import AST.ASTVisitor;
import Util.position;


public class formatstringExprNode extends ExprNode{
    public ArrayList<String> str = new ArrayList<>();
    public ArrayList<ExprNode> expr = new ArrayList<>();

    public formatstringExprNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
