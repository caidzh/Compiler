package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;
import Util.info.Exprinfo;
import Util.info.Typeinfo;

public class conststrExprNode extends literalExprNode{
    public String val;
    public conststrExprNode(String val,position pos){
        super(pos);
        this.val = val;
        this.exprinfo = new Exprinfo(pos, new Typeinfo("string"), false, false, false, "");
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
