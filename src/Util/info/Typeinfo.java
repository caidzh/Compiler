package Util.info;

import Grammar.MxParser;
import Util.scope.position;

public class Typeinfo extends info{
    public String type;
    public boolean isInt = false, isBool = false, isString=false, isVoid=false;
    public int dim = 0;
    public Typeinfo(MxParser.TypenameContext ctx){
        super("", new position(ctx));
        this.dim = ctx.LeftBracket().size();
        this.type = ctx.type().toString();
        this.isInt = ctx.type().Int()!=null;
        this.isBool = ctx.type().Bool()!=null;
        this.isString = ctx.type().String()!=null;
        this.isVoid = ctx.type().Void()!=null;
    }
    public Typeinfo(MxParser.TypeContext ctx){
        super("", new position(ctx));
        this.type = ctx.toString();
        this.isInt = ctx.Int()!=null;
        this.isBool = ctx.Bool()!=null;
        this.isString = ctx.String()!=null;
        this.isVoid = ctx.Void()!=null;
    }
    public Typeinfo(String type){
        super("", null);
        this.type = type;
        this.isInt = (type == "int");
        this.isBool = (type == "bool");
        this.isString = (type == "string");
        this.isVoid = (type == "void");
    }
    boolean isBasic(){
        return isInt|isBool|isString|isVoid;
    }
    boolean isArray(){
        return dim>0;
    }
}
