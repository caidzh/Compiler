package AST;

import Util.info.Typeinfo;
import Util.scope.position;

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
