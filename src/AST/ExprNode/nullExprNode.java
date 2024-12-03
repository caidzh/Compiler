package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;
import Util.info.*;

public class nullExprNode extends literalExprNode{
    public nullExprNode(position pos){
        super(pos);
        this.exprinfo = new Exprinfo(pos, new Typeinfo("null"), false, false, false, "");
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
