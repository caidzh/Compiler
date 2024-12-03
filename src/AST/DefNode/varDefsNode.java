package AST.DefNode;

import Util.position;
import Util.info.Typeinfo;

import java.util.ArrayList;

import AST.ASTVisitor;

public class varDefsNode extends DefNode{
    public Typeinfo type;
    public ArrayList<varDefNode> Defs = new ArrayList<>();
    
    public varDefsNode(Typeinfo type,ArrayList<varDefNode> Defs,position pos){
        super(pos);
        this.type = new Typeinfo(type);
        this.Defs = new ArrayList<varDefNode>(Defs);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
