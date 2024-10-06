package AST;

import Util.position;
import Util.Type;

import java.util.ArrayList;

public class newarrayExprNode extends ExprNode{
    public Type type;
    public arrayinitExprNode arrayinitial;
    public ArrayList<ExprNode> size = new ArrayList<>();
    
    public newarrayExprNode(position pos, Type type){
        super(pos);
        this.type=type;
    }

    public int getdim(){
        return size.size();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
