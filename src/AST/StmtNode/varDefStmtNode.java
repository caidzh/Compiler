package AST.StmtNode;

import AST.ASTVisitor;
import AST.DefNode.*;
import Util.position;

public class varDefStmtNode extends StmtNode{
    public varDefsNode vardef;

    public varDefStmtNode(varDefsNode vardef, position pos) {
        super(pos);
        this.vardef = vardef;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
