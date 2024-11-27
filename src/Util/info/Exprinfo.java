package Util.info;

import Util.position;

public class Exprinfo extends Typeinfo {
    public Typeinfo type;
    public boolean isLvalue = false;
    public boolean isFunc = false;

    public Exprinfo(position pos, Typeinfo type, boolean isLvalue, boolean isFunc) {
        super(type.name, pos);
        this.type = type;
        this.isLvalue = isLvalue;
        this.isFunc = isFunc;
    }

    public Exprinfo(Exprinfo rhs) {
        super(rhs.name, rhs.pos);
        this.type = rhs.type;
        this.isLvalue = rhs.isLvalue;
        this.isFunc = rhs.isFunc;
    }
}
