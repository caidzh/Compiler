package AST;

import Util.info.Typeinfo;
import Util.scope.position;

import java.util.ArrayList;

public class newarrayExprNode extends ExprNode{
    public Typeinfo type;
    public arrayinitExprNode arrayinitial;
    public ArrayList<ExprNode> size = new ArrayList<>();
    
    public newarrayExprNode(position pos, Typeinfo type){
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
