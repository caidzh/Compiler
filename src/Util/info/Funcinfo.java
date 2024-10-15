package Util.info;

import java.util.HashMap;
import Util.scope.position;

import Grammar.MxParser;

public class Funcinfo extends info{
    public Typeinfo type;
    public HashMap<String,Typeinfo> argtype = new HashMap<>();

    public Funcinfo(MxParser.FuncDefContext ctx){
        super(new position(ctx));
        this.type = new Typeinfo(ctx.typename());
        ctx.arglist().arg().forEach(cd -> this.argtype.put(cd.argvar().name.getText(),new Typeinfo(cd.typename())));
    }
}
