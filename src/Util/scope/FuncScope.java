package Util.scope;

import Util.info.*;

public class FuncScope extends Scope {
    public Typeinfo retType;

    public FuncScope(Scope parenScope, Typeinfo type) {
        super(parenScope);
        retType = new Typeinfo(type);
    }

    public FuncScope(FuncScope parenScope){
        super(parenScope);
        retType = new Typeinfo(parenScope.retType);
    }
}
