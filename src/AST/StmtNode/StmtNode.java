package AST.StmtNode;

import AST.ASTNode;
import Util.scope.position;

public abstract class StmtNode extends ASTNode {
    public StmtNode(position pos) {
        super(pos);
    }
}
