package AST.DefNode;

import Util.info.Typeinfo;
import Util.scope.position;

import java.util.ArrayList;

import AST.ASTVisitor;
import AST.StmtNode.StmtNode;

public class varDefsNode extends StmtNode{
    public Typeinfo type;
    public ArrayList<varDefNode> Defs = new ArrayList<>();
    
    public varDefsNode(Typeinfo type,ArrayList<varDefNode> Defs,position pos){
        super(pos);
        this.type=type;
        this.Defs=Defs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
