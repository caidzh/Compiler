package AST.DefNode;

import Util.position;
import Util.info.Typeinfo;

import java.util.ArrayList;

import AST.ASTVisitor;
import AST.StmtNode.suiteStmtNode;

public class funcDefNode extends DefNode{
    public String name;
    public ArrayList<varDefsNode> args = new ArrayList<>();
    public Typeinfo type;
    public suiteStmtNode body = null;
    
    public funcDefNode(position pos, String name, Typeinfo type){
        super(pos);
        this.name=name;
        this.type=type;
    }

    public int paramnumber(){
        return args.size();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
