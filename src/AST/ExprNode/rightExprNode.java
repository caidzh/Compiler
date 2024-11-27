package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;

public class rightExprNode extends ExprNode{
    public ExprNode lhs;
    public enum rightOpType {
        Inc, Dec
    }
    public rightOpType opCode;

    public rightExprNode(ExprNode lhs, rightOpType opCode, position pos) {
        super(pos);
        this.lhs = lhs;
        this.opCode = opCode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
