package AST;

import java.util.ArrayList;

import AST.DefNode.DefNode;
import Util.position;

public class RootNode extends ASTNode{
    public ArrayList<DefNode> Defs = new ArrayList<>();

    public RootNode(position pos) {
        super(pos);
        
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
