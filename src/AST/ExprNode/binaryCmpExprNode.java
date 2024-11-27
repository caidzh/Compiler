package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;

public class binaryCmpExprNode extends ExprNode {
    public ExprNode lhs, rhs;
    public enum binaryCmpType {
        Ge, Le, Geq, Leq, Neq, Eq
    }
    public binaryCmpType opCode;

    public binaryCmpExprNode(ExprNode lhs, ExprNode rhs, binaryCmpType opCode, position pos) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        this.opCode = opCode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
