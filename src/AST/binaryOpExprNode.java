package AST;

import Util.position;

public class binaryOpExprNode extends ExprNode {
    public ExprNode lhs, rhs;
    public enum binaryOpType {
        Add, Sub, Mul, Div, Mod, RightShift, LeftShift, BitAnd, BitXor, BitOr, And, Or
    }
    public binaryOpType opCode;

    public binaryOpExprNode(ExprNode lhs, ExprNode rhs, binaryOpType opCode, position pos) {
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
