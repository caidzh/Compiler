package AST;

import java.util.ArrayList;

import Util.position;

public class funcExprNode extends ExprNode{
    public ExprNode name;
    public ArrayList<ExprNode> args = new ArrayList<>();

    public funcExprNode(position pos, ExprNode name){
        super(pos);
        this.name=name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
