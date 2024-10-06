package AST;

import Util.position;
import Util.Type;

import java.util.ArrayList;

public class funcDefNode extends ExprNode{
    public String name;
    public ArrayList<varDefsNode> parameter = new ArrayList<>();
    public Type type;
    public suiteStmtNode body = null;
    
    public funcDefNode(position pos, String name, Type type){
        super(pos);
        this.name=name;
        this.type=type;
    }

    public int paramnumber(){
        return parameter.size();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
