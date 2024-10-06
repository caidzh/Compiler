package AST;

import Util.position;
import Util.Type;

public class newvarExprNode extends ExprNode{
    public Type type;
    
    public newvarExprNode(position pos, Type type){
        super(pos);
        this.type=type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
