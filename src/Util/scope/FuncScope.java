package Util.scope;

import Util.info.*;

public class FuncScope extends Scope {
    public Typeinfo retType;

    public FuncScope(Scope parenScope, Typeinfo type) {
        super(parenScope);
        retType = type;
    }
}
