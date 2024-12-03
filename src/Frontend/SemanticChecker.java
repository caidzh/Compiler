package Frontend;

import org.antlr.v4.parse.ANTLRParser.elementOptions_return;

import AST.*;
import AST.DefNode.*;
import AST.ExprNode.*;
import AST.StmtNode.*;
import AST.ExprNode.binaryCmpExprNode.binaryCmpType;
import AST.ExprNode.binaryOpExprNode.binaryOpType;
import AST.ExprNode.leftExprNode.leftOpType;
import Util.error.semanticError;
import Util.info.*;
import Util.scope.*;

public class SemanticChecker implements ASTVisitor {
    private globalScope gScope;
    private Scope scope;
    private int loop = 0;
    private boolean isinClass = false;
    private String inClass = null;
    private boolean inFunc = false;
    private boolean HasMain = false;
    private Typeinfo retType = null;

    private void out() {
        scope = scope.parentScope();
    }

    public SemanticChecker(globalScope gScope) {
        this.gScope = gScope;
        scope = new Scope(gScope);
    }

    @Override
    public void visit(RootNode it) {
        for (DefNode cd : it.Defs)
            if (!(cd instanceof varDefNode))
                cd.accept(this);
        if (!HasMain)
            throw new semanticError("does not contain a main function", it.pos);
    }

    @Override
    public void visit(funcDefNode it) {
        inFunc = true;
        scope = new FuncScope(scope, it.type);
        retType = new Typeinfo(it.type);
        if (!gScope.classes.containsKey(it.type.type))
            throw new semanticError("undefined type", it.pos);
        if (it.name.equals("main")) {
            HasMain = true;
            if (!it.type.isInt)
                throw new semanticError("main function should return an int expression", it.pos);
            if (it.args.size() > 0)
                throw new semanticError("number of main function's arguments > 0", it.pos);
        }
        for (var cd : it.args) {
            // varDefNode var = cd.Defs.get(0);
            // scope.defineVariable(var.name, cd.type, var.pos);
            cd.accept(this);
        }
        it.body.accept(this);
        inFunc = false;
        out();
    }

    @Override
    public void visit(classDefNode it) {
        isinClass = true;
        inClass = it.name;
        scope = new ClassScope(scope);
        for (var cd : it.Defs) {
            if (cd instanceof varDefsNode) {
                // for (var v : ((varDefsNode) cd).Defs) {
                // scope.defineVariable(v.name, ((varDefsNode) cd).type, v.pos);
                cd.accept(this);
                // }
            }
        }
        for (var cd : it.Defs)
            if (cd instanceof funcDefNode) {
                if (((funcDefNode) cd).name.equals(it.name))
                    throw new semanticError("Constructor Type Error", it.pos);
                cd.accept(this);
            }
        if (it.constructor != null) {
            inFunc = true;
            retType = new Typeinfo("void");
            it.constructor.accept(this);
            inFunc = false;
        }
        isinClass = false;
        out();
    }

    @Override
    public void visit(varDefsNode it) {
        if (it.type.isVoid)
            throw new semanticError("variable cannot be void", it.pos);
        for (var cd : it.Defs) {
            if (cd.init != null) {
                cd.init.accept(this);
                // System.out.printf("%s %d %s %d\n", it.type.type, it.type.dim,
                // cd.init.exprinfo.type.type,
                // cd.init.exprinfo.type.dim);
                if (!it.type.equal(cd.init.exprinfo.type) && !cd.init.exprinfo.type.isNull)
                    throw new semanticError("variable type mismatch initial value type", it.pos);
            }
            scope.defineVariable(cd.name, it.type, it.pos);
        }
    }

    @Override
    public void visit(varDefNode it) {
    }

    @Override
    public void visit(ExprNode it) {
        it.accept(this);
    }

    @Override
    public void visit(binaryOpExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        it.exprinfo = new Exprinfo(it.lhs.exprinfo);
        it.exprinfo.isLvalue = false;
        if (it.lhs.exprinfo.type.dim > 0 || it.rhs.exprinfo.type.dim > 0)
            throw new semanticError("operation argument can not be an array", it.pos);
        if (!it.lhs.exprinfo.type.equal(it.rhs.exprinfo.type))
            throw new semanticError("operation arguments need to have the same type", it.pos);
        if (!it.exprinfo.type.isBasic())
            throw new semanticError("binary operation arguments' type should be basic", it.pos);
        if (it.exprinfo.type.isBool) {
            if (!it.opCode.equals(binaryOpType.And) && !it.opCode.equals(binaryOpType.Or))
                throw new semanticError("boolean variables can only perform AND and OR operations", it.pos);
        }
        if (it.exprinfo.type.isString) {
            if (!it.opCode.equals(binaryOpType.Add))
                throw new semanticError("string variables can only perform ADD operation", it.pos);
        }
        if (it.exprinfo.type.isInt) {
            if (it.opCode.equals(binaryOpType.And) || it.opCode.equals(binaryOpType.Or))
                throw new semanticError("int variables can not perform AND or OR operations", it.pos);
        }
        if (it.exprinfo.type.isVoid)
            throw new semanticError("void variables can not perform operation", it.pos);
        if (it.exprinfo.type.dim > 0)
            throw new semanticError("array variables can only perform EQ and NEQ operations", it.pos);
    }

    @Override
    public void visit(binaryCmpExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        it.exprinfo = new Exprinfo(it.pos, new Typeinfo("bool"), false, false, false, "");
        if (it.opCode == binaryCmpType.Eq || it.opCode == binaryCmpType.Neq) {
            if (it.lhs.exprinfo.type.dim > 0 || it.rhs.exprinfo.type.dim > 0) {
                if (it.lhs.exprinfo.type.dim > 0 && it.rhs.exprinfo.type.dim == 0 && !it.rhs.exprinfo.isNull)
                    throw new semanticError("binary compare error", it.pos);
                if (it.lhs.exprinfo.type.dim == 0 && !it.lhs.exprinfo.isNull && it.rhs.exprinfo.type.dim > 0)
                    throw new semanticError("binary compare error", it.pos);
            } else {
                if (!it.lhs.exprinfo.type.isNull && !it.rhs.exprinfo.type.isNull) {
                    if (!it.lhs.exprinfo.type.equal(it.rhs.exprinfo.type))
                        throw new semanticError("binary compare error", it.pos);
                } else {
                    if (it.lhs.exprinfo.type.isNull) {
                        if (it.rhs.exprinfo.type.isBasic() && it.rhs.exprinfo.type.dim == 0)
                            throw new semanticError("binary compare error", it.pos);
                    }
                    if (it.rhs.exprinfo.type.isNull) {
                        if (it.lhs.exprinfo.type.isBasic() && it.lhs.exprinfo.type.dim == 0)
                            throw new semanticError("binary compare error", it.pos);
                    }
                }
            }
        } else {
            // System.out.printf("%s %d %s
            // %d\n",it.lhs.exprinfo.type.type,it.lhs.exprinfo.type.dim,it.rhs.exprinfo.type.type,it.rhs.exprinfo.type.dim);
            if (it.lhs.exprinfo.isBool || it.rhs.exprinfo.isBool)
                throw new semanticError("binary compare error", it.pos);
            if (!it.lhs.exprinfo.type.isBasic() || !it.rhs.exprinfo.type.isBasic())
                throw new semanticError("binary compare error", it.pos);
            if (it.lhs.exprinfo.type.dim > 0 || it.rhs.exprinfo.type.dim > 0)
                throw new semanticError("binary compare error", it.pos);
            if (!it.lhs.exprinfo.type.equal(it.rhs.exprinfo.type))
                throw new semanticError("binary compare error", it.pos);
        }
    }

    @Override
    public void visit(assignExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        it.exprinfo = new Exprinfo(it.lhs.exprinfo);
        if (!it.lhs.isAssignable())
            throw new semanticError("cannot assign to a non-lvalue.", it.pos);
        if (!it.rhs.exprinfo.type.isNull) {
            if (!it.lhs.exprinfo.type.equal(it.rhs.exprinfo.type))
                throw new semanticError("cannot assign to two variables with different dimensions or types", it.pos);
        }
        if (it.rhs.exprinfo.type.isNull && it.lhs.exprinfo.type.isBasic() && it.lhs.exprinfo.type.dim == 0)
            throw new semanticError("cannot assign to two variables with different dimensions or types", it.pos);
    }

    @Override
    public void visit(parenExprNode it) {
        it.expr.accept(this);
        it.exprinfo = new Exprinfo(it.expr.exprinfo);
    }

    @Override
    public void visit(arrayExprNode it) {
        it.name.accept(this);
        it.index.accept(this);
        it.exprinfo = new Exprinfo(it.name.exprinfo);
        it.exprinfo.type.dim -= 1;
        // System.out.printf("??? %s %d\n", it.exprinfo.type.type,
        // it.exprinfo.type.dim);
        if (!it.index.exprinfo.type.isInt || it.index.exprinfo.type.dim > 0)
            throw new semanticError("index should be an integer", it.pos);
    }

    @Override
    public void visit(arrayinitExprNode it) {
        it.arrayinits.get(0).accept(this);
        Exprinfo info = new Exprinfo(it.arrayinits.get(0).exprinfo);
        for (int i = 1; i < it.arrayinits.size(); i++) {
            it.arrayinits.get(i).accept(this);
            if (!info.equal(it.arrayinits.get(i).exprinfo))
                throw new semanticError("array initial value type mismatch", it.pos);
        }
        it.exprinfo = new Exprinfo(info);
        it.exprinfo.type.dim += 1;
    }

    @Override
    public void visit(newarrayExprNode it) {
        if (!gScope.classes.containsKey(it.type.type))
            throw new semanticError("undefined type", it.pos);
        it.exprinfo = new Exprinfo(it.type.pos, it.type, true, false, false, "");
        it.exprinfo.type.dim = it.getdim();
        if (it.arrayinitial != null) {
            it.arrayinitial.accept(this);
            // System.out.printf("%s %d %s
            // %d",it.exprinfo.type.type,it.exprinfo.type.dim,it.arrayinitial.exprinfo.type.type,it.arrayinitial.exprinfo.type.dim);
            if (it.arrayinitial.exprinfo.type.dim != it.exprinfo.type.dim)
                throw new semanticError("array initial dimension error", it.pos);
        }
        boolean prefix = true;
        for (var cd : it.size) {
            if (cd != null) {
                if (!prefix)
                    throw new semanticError("the shape of multidimensional array must be specified from left to right",
                            it.pos);
                cd.accept(this);
                if (!cd.exprinfo.type.isInt || cd.exprinfo.type.dim > 0)
                    throw new semanticError("initial size should be an integer", it.pos);
            } else
                prefix = false;
        }
    }

    @Override
    public void visit(newvarExprNode it) {
        if (!gScope.classes.containsKey(it.type.type))
            throw new semanticError("undefined type", it.pos);
        if (it.type.isVoid)
            throw new semanticError("new expression cannot apply to void", it.pos);
        Classinfo value = gScope.classes.get(it.type.type);
        if (it.type.isBasic())
            it.exprinfo = new Exprinfo(it.pos, new Typeinfo(value.name), true, false, false, "");
        else
            it.exprinfo = new Exprinfo(it.pos, new Typeinfo(value.name), true, false, true, value.name);
    }

    @Override
    public void visit(memberExprNode it) {
        it.name.searchclass = true;
        it.name.accept(this);
        if (it.searchfunc) {
            // System.out.printf("%s %s\n",it.name.exprinfo.fromclass,it.Identifier);
            if (isinClass && gScope.classes.get(inClass).function.get(it.Identifier) != null) {
                Typeinfo type = gScope.classes.get(inClass).function.get(it.Identifier).type;
                it.exprinfo = new Exprinfo(it.pos, new Typeinfo(type), false, true, true, inClass);
                it.exprinfo.name = it.Identifier;
            } else if (gScope.classes.get(it.name.exprinfo.type.type) != null
                    && gScope.classes.get(it.name.exprinfo.type.type).function.get(it.Identifier) != null) {
                Typeinfo type = gScope.classes.get(it.name.exprinfo.type.type).function.get(it.Identifier).type;
                it.exprinfo = new Exprinfo(it.pos, new Typeinfo(type), false, true, true, it.name.exprinfo.type.type);
                it.exprinfo.name = it.Identifier;
            } else if (gScope.functions.containsKey(it.Identifier)) {
                if (it.Identifier.equals("size")
                        && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                    if (it.name.exprinfo.type.dim == 0)
                        throw new semanticError("the member should be an array", it.pos);
                    Typeinfo type = new Typeinfo("int");
                    it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                    it.exprinfo.name = "size";
                } else if (it.Identifier.equals("length")
                        && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                    if (it.name.exprinfo.type.dim > 0 || !it.name.exprinfo.type.isString)
                        throw new semanticError("the member should be a string", it.pos);
                    Typeinfo type = new Typeinfo("int");
                    it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                    it.exprinfo.name = "length";
                } else if (it.Identifier.equals("substring")
                        && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                    if (it.name.exprinfo.type.dim > 0 || !it.name.exprinfo.type.isString)
                        throw new semanticError("the member should be a string", it.pos);
                    Typeinfo type = new Typeinfo("string");
                    it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                    it.exprinfo.name = "substring";
                } else if (it.Identifier.equals("parseInt")
                        && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                    if (it.name.exprinfo.type.dim > 0 || !it.name.exprinfo.type.isString)
                        throw new semanticError("the member should be a string", it.pos);
                    Typeinfo type = new Typeinfo("int");
                    it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                    it.exprinfo.name = "parseInt";
                } else if (it.Identifier.equals("ord")
                        && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                    if (it.name.exprinfo.type.dim > 0 || !it.name.exprinfo.type.isString)
                        throw new semanticError("the member should be a string", it.pos);
                    Typeinfo type = new Typeinfo("int");
                    it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                    it.exprinfo.name = "ord";
                }
                // Typeinfo type = gScope.functions.get(it.Identifier).type;
                // it.exprinfo = new Exprinfo(it.pos, new Typeinfo(type), false, true, false,
                // "");
                // it.exprinfo.name = it.Identifier;
            } else
                throw new semanticError("undefined function", it.pos);
        } else {
            if (it.Identifier.equals("size")
                    && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                if (it.name.exprinfo.type.dim == 0)
                    throw new semanticError("the member should be an array", it.pos);
                Typeinfo type = new Typeinfo("int");
                it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                it.exprinfo.name = "size";
            } else if (it.Identifier.equals("length")
                    && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                if (it.name.exprinfo.type.dim > 0 || !it.name.exprinfo.type.isString)
                    throw new semanticError("the member should be a string", it.pos);
                Typeinfo type = new Typeinfo("int");
                it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                it.exprinfo.name = "length";
            } else if (it.Identifier.equals("substring")
                    && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                if (it.name.exprinfo.type.dim > 0 || !it.name.exprinfo.type.isString)
                    throw new semanticError("the member should be a string", it.pos);
                Typeinfo type = new Typeinfo("string");
                it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                it.exprinfo.name = "substring";
            } else if (it.Identifier.equals("parseInt")
                    && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                if (it.name.exprinfo.type.dim > 0 || !it.name.exprinfo.type.isString)
                    throw new semanticError("the member should be a string", it.pos);
                Typeinfo type = new Typeinfo("int");
                it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                it.exprinfo.name = "parseInt";
            } else if (it.Identifier.equals("ord")
                    && !gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                if (it.name.exprinfo.type.dim > 0 || !it.name.exprinfo.type.isString)
                    throw new semanticError("the member should be a string", it.pos);
                Typeinfo type = new Typeinfo("int");
                it.exprinfo = new Exprinfo(it.pos, type, false, true, false, "");
                it.exprinfo.name = "ord";
            } else {
                if (it.name.exprinfo.dim > 0)
                    throw new semanticError("the member should be a variable", it.pos);
                if (it.name.exprinfo.isBasic())
                    throw new semanticError("basic type does not contain member", it.pos);
                if (!gScope.classes.containsKey(it.name.exprinfo.type.type))
                    throw new semanticError("undefined class", it.pos);
                if (gScope.classes.get(it.name.exprinfo.type.type).member.containsKey(it.Identifier)) {
                    Typeinfo type = gScope.classes.get(it.name.exprinfo.type.type).member.get(it.Identifier);
                    // System.out.printf("%s -> %s\n",it.name.exprinfo.type.type,type.type);
                    it.exprinfo = new Exprinfo(it.pos, type, true, false, true, it.name.exprinfo.type.type);
                } else {
                    if (gScope.classes.get(it.name.exprinfo.type.type).function.containsKey(it.Identifier)) {
                        Typeinfo type = gScope.classes.get(it.name.exprinfo.type.type).function.get(it.Identifier).type;
                        it.exprinfo = new Exprinfo(it.pos, type, false, true, true, it.name.exprinfo.type.type);
                        it.exprinfo.name = it.Identifier;
                    } else
                        throw new semanticError("undefined member", it.pos);
                }
            }
        }
    }

    @Override
    public void visit(rightExprNode it) {
        it.lhs.accept(this);
        if (!it.lhs.exprinfo.isLvalue)
            throw new semanticError("only lvalue can perform INC/DEC operation", it.pos);
        if (it.lhs.exprinfo.type.isInt && it.lhs.exprinfo.type.dim == 0) {
            it.exprinfo = new Exprinfo(it.lhs.exprinfo);
            it.exprinfo.isLvalue = false;
        } else
            throw new semanticError("only integer can perform INC/DEC operation", it.pos);
    }

    @Override
    public void visit(leftExprNode it) {
        it.rhs.accept(this);
        if (!it.rhs.exprinfo.isLvalue && (it.opCode.equals(leftOpType.Inc) || it.opCode.equals(leftOpType.Dec)))
            throw new semanticError("only lvalue can perform INC/DEC operation", it.pos);
        if (it.opCode == leftOpType.Not) {
            if (it.rhs.exprinfo.type.isBool && it.rhs.exprinfo.type.dim == 0)
                it.exprinfo = new Exprinfo(it.rhs.exprinfo);
            else
                throw new semanticError("only boolean can perform NOT operation", it.pos);
        } else {
            if (it.rhs.exprinfo.type.isInt && it.rhs.exprinfo.type.dim == 0)
                it.exprinfo = new Exprinfo(it.rhs.exprinfo);
            else
                throw new semanticError("only integer can perform INC/DEC operation", it.pos);
        }
    }

    @Override
    public void visit(literalExprNode it) {
        if (it instanceof intExprNode) {
            it.exprinfo = new Exprinfo(it.pos, new Typeinfo("int"), false, false, false, "");
            it.exprinfo.isInt = true;
        }
        if (it instanceof boolExprNode) {
            it.exprinfo = new Exprinfo(it.pos, new Typeinfo("bool"), false, false, false, "");
            it.exprinfo.isBool = true;
        }
        if (it instanceof nullExprNode) {
            it.exprinfo = new Exprinfo(it.pos, new Typeinfo("null"), false, false, false, "");
            it.exprinfo.isNull = true;
        }
        if (it instanceof conststrExprNode) {
            it.exprinfo = new Exprinfo(it.pos, new Typeinfo("string"), false, false, false, "");
            it.exprinfo.isString = true;
        }
    }

    @Override
    public void visit(atomExprNode it) {
        if (it.searchfunc) {
            if (isinClass && gScope.classes.get(inClass).function.get(it.str) != null) {
                it.exprinfo = new Exprinfo(it.pos, new Typeinfo(""), false, true, true, inClass);
                it.exprinfo.name = it.str;
            } else if (gScope.functions.containsKey(it.str)) {
                it.exprinfo = new Exprinfo(it.pos, new Typeinfo(""), false, true, false, "");
                it.exprinfo.name = it.str;
            } else
                throw new semanticError("undefined function", it.pos);
        } else {
            if (it.str.equals("this")) {
                if (!isinClass)
                    throw new semanticError("this must be in class", it.pos);
                it.exprinfo = new Exprinfo(it.pos, new Typeinfo(inClass), true, false, true, inClass);
            } else {
                if (gScope.functions.containsKey(it.str)) {
                    it.exprinfo = new Exprinfo(it.pos, new Typeinfo(""), false, true, false, "");
                    it.exprinfo.name = it.str;
                } else {
                    if (scope.containsVariable(it.str, true)) {
                        Typeinfo type = scope.getType(it.str, true);
                        // System.out.printf("get %s type : %s %d\n", it.str, type.type, type.dim);
                        if (type.isBasic())
                            it.exprinfo = new Exprinfo(it.pos, type, true, false, false, "");
                        else
                            it.exprinfo = new Exprinfo(it.pos, type, true, false, true, type.type);
                    } else {
                        if (isinClass && gScope.classes.get(inClass).function.get(it.str) != null) {
                            it.exprinfo = new Exprinfo(it.pos, new Typeinfo(""), false, true, true, inClass);
                            it.exprinfo.name = it.str;
                        } else if (gScope.classes.containsKey(it.str)) {
                            it.exprinfo = new Exprinfo(it.pos, new Typeinfo(""), true, false, true, it.str);
                            it.exprinfo.name = it.str;
                        } else
                            throw new semanticError("undefined identifier", it.pos);
                    }
                }
            }
        }
    }

    @Override
    public void visit(formatstringExprNode it) {
        for (var cd : it.expr) {
            cd.accept(this);
            if (cd.exprinfo.dim > 0)
                throw new semanticError("format string can not contain array", it.pos);
            if (!(cd.exprinfo.isBool || cd.exprinfo.isInt || cd.exprinfo.isString))
                throw new semanticError("format string only contains bool/int/string", it.pos);
        }
        it.exprinfo.isString = true;
    }

    @Override
    public void visit(funcExprNode it) {
        it.name.searchfunc = true;
        it.name.accept(this);
        if (!it.name.exprinfo.isFunc)
            throw new semanticError("undefined function", it.pos);
        if (!it.name.exprinfo.isfromclass && !gScope.functions.containsKey(it.name.exprinfo.name))
            throw new semanticError("undefined function", it.pos);
        if (it.name.exprinfo.isfromclass
                && !gScope.classes.get(it.name.exprinfo.fromclass).function.containsKey(it.name.exprinfo.name))
            throw new semanticError("undefined function", it.pos);
        Funcinfo f = null;
        if (!it.name.exprinfo.isfromclass)
            f = gScope.functions.get(it.name.exprinfo.name);
        else
            f = gScope.classes.get(it.name.exprinfo.fromclass).function.get(it.name.exprinfo.name);
        for (int i = 0; i < it.args.size(); i++) {
            it.args.get(i).accept(this);
            if (!it.args.get(i).exprinfo.type.isNull) {
                if (!f.argtype.get(i).equal(it.args.get(i).exprinfo.type))
                    throw new semanticError("function arguments type mismatch", it.pos);
            } else {
                if (f.argtype.get(i).isBasic() && f.argtype.get(i).dim == 0)
                    throw new semanticError("function arguments type mismatch", it.pos);
            }
        }
        it.exprinfo = new Exprinfo(it.pos, f.type, false, false, false, "");
    }

    @Override
    public void visit(ternaryExprNode it) {
        it.cond.accept(this);
        if (!it.cond.exprinfo.type.isBool || it.cond.exprinfo.type.dim > 0)
            throw new semanticError("condition must be a boolean expression", it.pos);
        it.thenstmt.accept(this);
        it.elsestmt.accept(this);
        if (!it.thenstmt.exprinfo.type.isNull && !it.elsestmt.exprinfo.type.isNull) {
            if (!it.thenstmt.exprinfo.type.equal(it.elsestmt.exprinfo.type))
                throw new semanticError("thenstmt type mismatch elsestmt type", it.pos);
            it.exprinfo = new Exprinfo(it.thenstmt.exprinfo);
        } else {
            if ((it.thenstmt.exprinfo.type.isBasic() && it.thenstmt.exprinfo.type.dim == 0)
                    || (it.elsestmt.exprinfo.type.isBasic() && it.elsestmt.exprinfo.type.dim == 0))
                throw new semanticError("thenstmt type mismatch elsestmt type", it.pos);
            if (!it.thenstmt.exprinfo.type.isNull)
                it.exprinfo = new Exprinfo(it.thenstmt.exprinfo);
            else if (!it.elsestmt.exprinfo.type.isNull)
                it.exprinfo = new Exprinfo(it.elsestmt.exprinfo);
            else
                it.exprinfo = new Exprinfo(it.pos, new Typeinfo("null"), false, false, false, "");
        }

    }

    @Override
    public void visit(ifStmtNode it) {
        it.condition.accept(this);
        if (!it.condition.exprinfo.type.isBool || it.condition.exprinfo.dim > 0)
            throw new semanticError("condition must be a boolean expression", it.pos);
        Scope s = scope;
        scope = new Scope(s);
        if (it.thenStmt != null)
            it.thenStmt.accept(this);
        scope = new Scope(s);
        if (it.elseStmt != null)
            it.elseStmt.accept(this);
        out();
    }

    @Override
    public void visit(forStmtNode it) {
        if (it.condition != null) {
            it.condition.accept(this);
            if (!it.condition.isexpr)
                throw new semanticError("condition must be a boolean expression", it.pos);
            if (!it.condition.exprinfo.type.isBool || it.condition.exprinfo.type.dim > 0)
                throw new semanticError("condition must be a boolean expression", it.pos);
        }
        if (it.initStmt != null)
            it.initStmt.accept(this);
        if (it.step != null)
            it.step.accept(this);
        scope = new Scope(scope);
        loop += 1;
        if (it.bodyStmt != null)
            it.bodyStmt.accept(this);
        loop -= 1;
        out();
    }

    @Override
    public void visit(returnStmtNode it) {
        if (!inFunc)
            throw new semanticError("return statement must be in function", it.pos);
        if (it.value != null) {
            it.value.accept(this);
            if (retType.isBasic() && retType.dim == 0) {
                if (!it.value.exprinfo.type.equal(retType))
                    throw new semanticError("return type mismatch", it.pos);
            } else {
                if (!it.value.exprinfo.type.equal(retType) && !it.value.exprinfo.type.isNull)
                    throw new semanticError("return type mismatch", it.pos);
            }
        } else {
            if (retType.isVoid == false)
                throw new semanticError("return type mismatch", it.pos);
        }
    }

    @Override
    public void visit(suiteStmtNode it) {
        if (scope instanceof ClassScope)
            scope = new ClassScope((ClassScope) scope);
        else {
            if (scope instanceof FuncScope)
                scope = new FuncScope((FuncScope) scope);
            else
                scope = new Scope(scope);
        }
        for (var cd : it.stmts)
            cd.accept(this);
        out();
    }

    @Override
    public void visit(pureExprStmtNode it) {
        it.isexpr = true;
        it.expr.accept(this);
        it.exprinfo = new Exprinfo(it.expr.exprinfo);
    }

    @Override
    public void visit(whileStmtNode it) {
        if (it.condition == null)
            throw new semanticError("missing condition", it.pos);
        it.condition.accept(this);
        if (!it.condition.exprinfo.type.isBool || it.condition.exprinfo.type.dim > 0)
            throw new semanticError("condition must be a boolean expression", it.pos);
        scope = new Scope(scope);
        loop += 1;
        if (it.bodyStmt != null)
            it.bodyStmt.accept(this);
        loop -= 1;
        out();
    }

    @Override
    public void visit(jumpStmtNode it) {
        if (loop == 0)
            throw new semanticError("jump must be in loop", it.pos);
    }

    @Override
    public void visit(exprStmtNode it) {
        it.isexpr = true;
        it.expr.accept(this);
        it.exprinfo = new Exprinfo(it.expr.exprinfo);
    }

    @Override
    public void visit(varDefStmtNode it) {
        it.vardef.accept(this);
    }
}
