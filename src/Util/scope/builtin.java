package Util.scope;

import Util.info.*;

public class builtin {
    static public Typeinfo IntType = new Typeinfo("int");
    static public Typeinfo BoolType = new Typeinfo("bool");
    static public Typeinfo StringType = new Typeinfo("string");
    static public Typeinfo VoidType = new Typeinfo("void");

    static public Typeinfo basetype[] = {IntType, BoolType, StringType, VoidType};

    static public Funcinfo print = new Funcinfo("print", VoidType, StringType);
    static public Funcinfo println = new Funcinfo("println", VoidType, StringType);
    static public Funcinfo printInt = new Funcinfo("printInt", VoidType, IntType);
    static public Funcinfo printlnInt = new Funcinfo("printlnInt", VoidType, IntType);
    static public Funcinfo getString = new Funcinfo("getString", StringType);
    static public Funcinfo getInt = new Funcinfo("getInt", IntType);
    static public Funcinfo toString = new Funcinfo("toString", StringType, IntType);

    static public Funcinfo func[] = {print, println, printInt, printlnInt, getString, getInt, toString};
}
