package AST.ExprNode;

import Util.scope.position;
import java.util.ArrayList;

import AST.ASTVisitor;


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
