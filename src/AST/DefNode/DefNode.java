package AST.DefNode;

import AST.ASTNode;
import Util.scope.position;

public abstract class DefNode extends ASTNode{
    // public Type type;
    // public entity val;

    public DefNode(position pos) {
        super(pos);
    }
}
