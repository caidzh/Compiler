package Util;

import java.util.HashMap;

import Grammar.MxParser;

public class Classinfo extends info{
    public HashMap<String,Typeinfo> member = new HashMap<>();
    public HashMap<String,Funcinfo> function = new HashMap<>();

    public Classinfo(MxParser.ClassDefContext ctx){
        super(new position(ctx));
        ctx.varDef().forEach(cd -> this.InitMember(cd));
        ctx.funcDef().forEach(cd -> this.function.put(cd.name.getText(),new Funcinfo(cd)));
    }

    public void InitMember(MxParser.VarDefContext ctx){
        Typeinfo type = new Typeinfo(ctx.typename());
        ctx.argvar().forEach(cd -> this.member.put(cd.name.getText(),type));
    }
}
