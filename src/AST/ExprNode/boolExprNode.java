package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;
import Util.info.Exprinfo;
import Util.info.Typeinfo;

public class boolExprNode extends literalExprNode{
    public boolean val;
    public boolExprNode(boolean val,position pos){
        super(pos);
        this.val = val;
        this.exprinfo = new Exprinfo(pos, new Typeinfo("bool"), false, false, false, "");
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
