package AST;

import Util.scope.position;

import java.util.ArrayList;

import AST.DefNode.DefNode;

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
