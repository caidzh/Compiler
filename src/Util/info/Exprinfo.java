package Util.info;

import Util.scope.position;

public class Exprinfo extends info{
    public Typeinfo type;

    public Exprinfo(position pos,Typeinfo type){
        super(pos);
        this.type = type;
    }
}
