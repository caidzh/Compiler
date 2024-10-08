package Util;

import Grammar.MxParser;

public class Type {
    public String type;
    public boolean isInt = false, isBool = false, isString=false, isVoid=false;
    public int dim = 0;
    public Type(MxParser.TypenameContext ctx){
        dim=ctx.LeftBracket().size();
        type=ctx.type().toString();
        isInt=ctx.type().Int()!=null;
        isBool=ctx.type().Bool()!=null;
        isString=ctx.type().String()!=null;
        isVoid=ctx.type().Void()!=null;
    }
    public Type(MxParser.TypeContext ctx){
        type=ctx.toString();
        isInt=ctx.Int()!=null;
        isBool=ctx.Bool()!=null;
        isString=ctx.String()!=null;
        isVoid=ctx.Void()!=null;
    }
    boolean isBasic(){
        return isInt|isBool|isString|isVoid;
    }
    boolean isArray(){
        return dim>0;
    }
}
