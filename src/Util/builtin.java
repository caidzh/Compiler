package Util;

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

    static public Funcinfo size = new Funcinfo("size", IntType);

    static public Funcinfo length = new Funcinfo("length", IntType);
    static public Funcinfo substring = new Funcinfo("substring", StringType, IntType, IntType);
    static public Funcinfo parseInt = new Funcinfo("parseInt", IntType);
    static public Funcinfo ord = new Funcinfo("ord", IntType, IntType);

    static public Funcinfo func[] = {print, println, printInt, printlnInt, getString, getInt, toString, size, length, substring, parseInt, ord};
}
