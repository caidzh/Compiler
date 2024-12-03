package Util.info;

import Util.position;

public class Exprinfo extends Typeinfo {
    public Typeinfo type;
    public boolean isLvalue = false;
    public boolean isFunc = false;
    public boolean isfromclass = false;
    public String fromclass;

    public Exprinfo(position pos, Typeinfo type, boolean isLvalue, boolean isFunc, boolean isfromclass, String fromclass) {
        super(type.name, pos);
        this.type = new Typeinfo(type);
        this.isLvalue = isLvalue;
        this.isFunc = isFunc;
        this.isfromclass = isfromclass;
        this.fromclass = fromclass;
    }

    public Exprinfo(Exprinfo rhs) {
        super(rhs.name, rhs.pos);
        this.type = new Typeinfo(rhs.type);
        this.isLvalue = rhs.isLvalue;
        this.isFunc = rhs.isFunc;
        this.isfromclass = rhs.isfromclass;
        this.fromclass = rhs.fromclass;
    }
}
