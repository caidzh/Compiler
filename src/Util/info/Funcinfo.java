package Util.info;

import java.util.ArrayList;

import AST.DefNode.funcDefNode;
import AST.DefNode.varDefsNode;
import Grammar.MxParser;
import Util.position;

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
        this.type = new Typeinfo(type);
        for (Typeinfo arg : args) {
            this.argtype.add(new Typeinfo(arg));
        }
    }

    public Funcinfo(funcDefNode it){
        super(it.name, it.pos);
        // System.out.printf("%s\n",it.name);
        this.type = new Typeinfo(it.type);
        for (varDefsNode cd : it.args){
            // System.out.printf("%s ",cd.type.type);
            this.argtype.add(new Typeinfo(cd.type));
        }
        // System.out.println();
    }
}
