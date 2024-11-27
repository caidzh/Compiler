package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;

public class leftExprNode extends ExprNode{
    public ExprNode rhs;
    public enum leftOpType {
        Inc, Dec, Not, BitNot, Sub
    }
    public leftOpType opCode;

    public leftExprNode(ExprNode rhs, leftOpType opCode, position pos) {
        super(pos);
        this.rhs = rhs;
        this.opCode = opCode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
