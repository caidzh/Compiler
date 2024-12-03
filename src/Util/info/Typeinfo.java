package Util.info;

import Grammar.MxParser;
import Util.position;

public class Typeinfo extends info {
    public String type;
    public boolean isInt = false, isBool = false, isString = false, isVoid = false, isNull = false;
    public int dim = 0;

    public Typeinfo(MxParser.TypenameContext ctx) {
        super("", new position(ctx));
        this.dim = ctx.LeftBracket().size();
        this.type = ctx.type().getText().toString();
        this.isInt = ctx.type().Int() != null;
        this.isBool = ctx.type().Bool() != null;
        this.isString = ctx.type().String() != null;
        this.isNull = false;
        this.isVoid = ctx.type().Void() != null;
    }

    public Typeinfo(MxParser.TypeContext ctx) {
        super("", new position(ctx));
        this.type = ctx.getText().toString();
        this.isInt = ctx.Int() != null;
        this.isBool = ctx.Bool() != null;
        this.isString = ctx.String() != null;
        this.isNull = false;
        this.isVoid = ctx.Void() != null;
        this.dim = 0;
    }

    public Typeinfo(String type, position pos) {
        super("", pos);
        this.type = type;
        this.isInt = (type == "int");
        this.isBool = (type == "bool");
        this.isString = (type == "string");
        this.isNull = (type == "null");
        this.isVoid = (type == "void");
        this.dim = 0;
    }

    public Typeinfo(String type) {
        super("", null);
        this.type = type;
        this.isInt = (type == "int");
        this.isBool = (type == "bool");
        this.isString = (type == "string");
        this.isNull = (type == "null");
        this.isVoid = (type == "void");
        this.dim = 0;
    }

    public Typeinfo(Typeinfo rhs) {
        super(rhs.name, rhs.pos);
        this.type = rhs.type;
        this.isInt = rhs.isInt;
        this.isBool = rhs.isBool;
        this.isString = rhs.isString;
        this.isNull = rhs.isNull;
        this.isVoid = rhs.isVoid;
        this.dim = rhs.dim;
    }

    public boolean equal(Typeinfo rhs) {
        return rhs.type.equals(type) && rhs.dim == dim;
    }

    public boolean typeEqual(Typeinfo rhs) {
        return rhs.type.equals(type);
    }

    public boolean isBasic() {
        return isInt | isBool | isString | isVoid;
    }

    public boolean isArray() {
        return dim > 0;
    }
}
