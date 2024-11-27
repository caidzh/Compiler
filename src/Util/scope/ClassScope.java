package Util.scope;

import java.util.HashMap;

import Util.error.semanticError;
import Util.info.*;

public class ClassScope extends Scope {
    public Classinfo Class;
    public HashMap<String, Funcinfo> Func=new HashMap<>();

    public ClassScope(Scope parentScope) {
        super(parentScope);
    }
    public ClassScope(){
        super(null);
    }

    public void insertFunc(Funcinfo func) {
        if (Func.containsKey(func.name)) {
            throw new semanticError("define function" + func.name + "twice in class" + Class.name, func.pos);
        }
        Func.put(func.name, func);
    }
}
