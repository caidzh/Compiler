package AST.ExprNode;

import AST.ASTNode;
import Util.info.Typeinfo;
import Util.scope.position;

public abstract class ExprNode extends ASTNode {
    public Typeinfo type;

    public ExprNode(position pos) {
        super(pos);
    }

    public boolean isAssignable() {
        return false;
    }
}
