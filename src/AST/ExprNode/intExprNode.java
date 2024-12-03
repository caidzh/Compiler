package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;
import Util.info.Exprinfo;
import Util.info.Typeinfo;

public class intExprNode extends literalExprNode{
    public int val;
    public intExprNode(int val,position pos){
        super(pos);
        this.val = val;
        this.exprinfo = new Exprinfo(pos, new Typeinfo("int"), false, false, false, "");
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
