package Util.scope;

import Util.position;
import Util.error.semanticError;

import java.util.HashMap;

import Util.info.*;

public class globalScope extends Scope {
    public HashMap<String, Classinfo> classes = new HashMap<>();
    public HashMap<String, Funcinfo> functions= new HashMap<>();

    public globalScope(Scope parentScope) {
        super(parentScope);
    }

    // public void addType(String name, Typeinfo t, position pos) {
    //     if (types.containsKey(name))
    //         throw new semanticError("multiple type definition of " + name, pos);
    //     types.put(name,t);
    // }

    public void addClass(String name, Classinfo t, position pos){
        if (classes.containsKey(name))
            throw new semanticError("multiple class definition of " + name, pos);
        if (functions.containsKey(name))
            throw new semanticError("class " + name + " is same as function", pos);
        classes.put(name,t);
    }

    public void addFunction(String name, Funcinfo t, position pos){
        if (functions.containsKey(name))
            throw new semanticError("multiple function definition of " + name, pos);
        if (classes.containsKey(name))
            throw new semanticError("function " + name + " is same as class", pos);
        functions.put(name,t);
    }

    // public Typeinfo getTypeFromName(String name, position pos) {
    //     if (types.containsKey(name)) return types.get(name);
    //     throw new semanticError("no such type: " + name, pos);
    // }

    public Classinfo getClassFromName(String name, position pos) {
        if (classes.containsKey(name)) return classes.get(name);
        throw new semanticError("no such class: " + name, pos);
    }

    public Funcinfo getFunctionFromName(String name, position pos) {
        if (functions.containsKey(name)) return functions.get(name);
        throw new semanticError("no such function: " + name, pos);
    }
}
