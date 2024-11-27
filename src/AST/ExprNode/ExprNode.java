package AST.ExprNode;

import AST.ASTNode;
import AST.ASTVisitor;
import Util.position;
import Util.info.Exprinfo;

public abstract class ExprNode extends ASTNode {
    public Exprinfo exprinfo;

    public ExprNode(position pos) {
        super(pos);
    }

    public boolean isAssignable() {
        return exprinfo.isLvalue;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
