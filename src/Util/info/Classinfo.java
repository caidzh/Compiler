package Util.info;

import java.util.HashMap;

import AST.DefNode.*;
import Util.scope.position;

import Grammar.MxParser;

public class Classinfo extends info{
    public HashMap<String, Typeinfo> member = new HashMap<>();
    public HashMap<String, Funcinfo> function = new HashMap<>();

    public Classinfo(MxParser.ClassDefContext ctx){
        super(ctx.Identifier().getText(), new position(ctx));
        ctx.varDef().forEach(cd -> this.InitMember(cd));
        ctx.funcDef().forEach(cd -> this.function.put(cd.name.getText(),new Funcinfo(cd)));
    }

    public Classinfo(classDefNode it){
        super(it.name, it.pos);
        for (DefNode def : it.Defs) {
            if (def instanceof varDefsNode) {
                this.Init((varDefsNode) def);
            } else if (def instanceof funcDefNode) {
                this.Init((funcDefNode) def);
            }
        }
    }

    public void InitMember(MxParser.VarDefContext ctx){
        Typeinfo type = new Typeinfo(ctx.typename());
        ctx.argvar().forEach(cd -> this.member.put(cd.name.getText(),type));
    }

    public void Init(varDefsNode it){
        Typeinfo type = it.type;
        for (varDefNode def : it.Defs)
            this.member.put(def.name, type);
    }

    public void Init(funcDefNode it){
        this.function.put(it.name,new Funcinfo(it));
    }
}
