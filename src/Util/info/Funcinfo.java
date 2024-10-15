package Util.info;

import java.util.ArrayList;

import AST.DefNode.funcDefNode;
import AST.DefNode.varDefsNode;
import Util.scope.position;

import Grammar.MxParser;

public class Funcinfo extends info{
    public Typeinfo type;
    public ArrayList<Typeinfo> argtype = new ArrayList<>();

    public Funcinfo(MxParser.FuncDefContext ctx){
        super(ctx.name.getText(), new position(ctx));
        this.type = new Typeinfo(ctx.typename());
        ctx.arglist().arg().forEach(cd -> this.argtype.add(new Typeinfo(cd.typename())));
    }
    
    public Funcinfo(String name, Typeinfo type, Typeinfo... args){
        super(name, null);
        this.type = type;
        for (Typeinfo arg : args) {
            argtype.add(arg);
        }
    }

    public Funcinfo(funcDefNode it){
        super(it.name, it.pos);
        this.type = it.type;
        for (varDefsNode cd : it.args) 
            argtype.add(cd.type);
    }
}
