package AST.ExprNode;

import AST.ASTVisitor;
import Util.position;
import Util.info.Typeinfo;

public class newvarExprNode extends ExprNode{
    public Typeinfo type;
    
    public newvarExprNode(position pos, Typeinfo type){
        super(pos);
        this.type=type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
