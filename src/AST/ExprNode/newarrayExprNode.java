package AST.ExprNode;

import Util.position;
import Util.info.Typeinfo;

import java.util.ArrayList;

import AST.ASTVisitor;

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
