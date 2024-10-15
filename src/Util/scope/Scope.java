package Util.scope;

// import MIR.register;
import Util.error.semanticError;

import java.util.HashMap;

import Util.info.Typeinfo;

public class Scope {

    private HashMap<String, Typeinfo> members;
    // public HashMap<String, register> entities = new HashMap<>();
    private Scope parentScope;


    public Scope(Scope parentScope) {
        members = new HashMap<>();
        this.parentScope = parentScope;
    }

    public Scope parentScope() {
        return parentScope;
    }

    public void defineVariable(String name, Typeinfo t, position pos) {
        if (members.containsKey(name))
            throw new semanticError("Semantic Error: variable redefine", pos);
        members.put(name, t);
    }

    public boolean containsVariable(String name, boolean lookUpon) {
        if (members.containsKey(name)) return true;
        else if (parentScope != null && lookUpon)
            return parentScope.containsVariable(name, true);
        else return false;
    }
    public Typeinfo getType(String name, boolean lookUpon) {
        if (members.containsKey(name)) return members.get(name);
        else if (parentScope != null && lookUpon)
            return parentScope.getType(name, true);
        return null;
    }
    // public register getEntity(String name, boolean lookUpon) {
    //     if (entities.containsKey(name)) return entities.get(name);
    //     else if (parentScope != null && lookUpon)
    //         return parentScope.getEntity(name, true);
    //     return null;
    // }
}
