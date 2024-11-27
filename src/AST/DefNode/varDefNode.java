package AST.DefNode;

import AST.ASTVisitor;
import AST.ExprNode.ExprNode;
import Util.position;

public class varDefNode extends DefNode {
    public String name;
    public ExprNode init = null;

    public varDefNode(String name, position pos) {
        super(pos);
        this.name = name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
