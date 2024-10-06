package AST;

import Util.Type;
import Util.position;

import java.util.ArrayList;

public class varDefsNode extends StmtNode{
    public Type type;
    public ArrayList<varDefNode> Defs = new ArrayList<>();
    
    public varDefsNode(Type type,ArrayList<varDefNode> Defs,position pos){
        super(pos);
        this.type=type;
        this.Defs=Defs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
