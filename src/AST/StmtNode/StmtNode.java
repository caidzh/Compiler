package AST.StmtNode;

import AST.ASTNode;
import Util.position;
import Util.info.*;

public abstract class StmtNode extends ASTNode {
    public boolean isexpr = false;
    public Exprinfo exprinfo;
    public StmtNode(position pos) {
        super(pos);
    }
}
