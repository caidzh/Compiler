package AST;

import Util.position;

public class varDefNode extends StmtNode {
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
