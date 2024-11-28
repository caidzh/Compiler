package Frontend;

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
    private boolean inClass = false;

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
    }

    @Override
    public void visit(funcDefNode it) {
        boolean HasMain = false;
        scope = new FuncScope(scope, it.type);
        if (it.name == "main") {
            HasMain = true;
            if (!it.type.isInt)
                throw new semanticError("main function should return an int expression", it.pos);
            if (it.args.size() > 0)
                throw new semanticError("number of main function's arguments > 0", null);
        }
        for (var cd : it.args) {
            varDefNode var = cd.Defs.get(0);
            scope.defineVariable(var.name, cd.type, var.pos);
            cd.accept(this);
        }
        it.body.accept(this);
        if (!HasMain)
            throw new semanticError("does not contain a main function", it.pos);
        out();
    }

    @Override
    public void visit(classDefNode it) {
        inClass = true;
        scope = new ClassScope(scope);
        for (var cd : it.Defs) {
            if (cd instanceof varDefsNode) {
                for (var v : ((varDefsNode) cd).Defs) {
                    scope.defineVariable(v.name, ((varDefsNode) cd).type, v.pos);
                    cd.accept(this);
                }
            }
        }
        for (var cd : it.Defs)
            if (cd instanceof funcDefNode)
                cd.accept(this);
        it.constructor.accept(this);
        inClass = false;
        out();
    }

    @Override
    public void visit(varDefsNode it) {
        for (var cd : it.Defs) {
            if (cd.init != null)
                cd.init.accept(this);
            if (it.type.name != cd.init.exprinfo.type.name)
                throw new semanticError("variable type mismatch initial value type", it.pos);
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
        if (it.exprinfo.type.equal(it.rhs.exprinfo.type))
            throw new semanticError("operation arguments need to have the same type", it.pos);
        if (!it.exprinfo.type.isBasic())
            throw new semanticError("binary operation arguments' type should be basic", it.pos);
        if (it.exprinfo.type.isBool) {
            if (it.opCode != binaryOpType.And && it.opCode != binaryOpType.Or)
                throw new semanticError("boolean variables can only perform AND and OR operations", it.pos);
        }
        if (it.exprinfo.type.isString) {
            if (it.opCode != binaryOpType.Add)
                throw new semanticError("string variables can only perform ADD operation", it.pos);
        }
        if (it.exprinfo.type.isInt) {
            if (it.opCode != binaryOpType.And && it.opCode != binaryOpType.Or)
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
        it.exprinfo.type.isBool = true;
        it.exprinfo.isLvalue = false;
        if (it.opCode == binaryCmpType.Eq || it.opCode == binaryCmpType.Neq) {
            if (it.lhs.exprinfo.type.dim > 0 || it.rhs.exprinfo.type.dim > 0) {
                if (it.lhs.exprinfo.type.dim > 0 && it.rhs.exprinfo.type.dim == 0 && !it.rhs.exprinfo.isNull)
                    throw new semanticError("binary compare error", it.pos);
                if (it.lhs.exprinfo.type.dim == 0 && !it.lhs.exprinfo.isNull && it.rhs.exprinfo.type.dim > 0)
                    throw new semanticError("binary compare error", it.pos);
            } else {
                if (!it.lhs.exprinfo.type.equal(it.rhs.exprinfo.type))
                    throw new semanticError("binary compare error", it.pos);
            }
        } else {
            if (it.lhs.exprinfo.isBool || it.rhs.exprinfo.isBool)
                throw new semanticError("binary compare error", it.pos);
            if (!it.lhs.exprinfo.isBasic() || !it.rhs.exprinfo.isBasic())
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
        if (it.lhs.exprinfo.equal(it.rhs.exprinfo))
            throw new semanticError("cannot assign to two arrays with different dimensions", it.pos);
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
        it.exprinfo.dim--;
        if (!it.index.exprinfo.isInt || it.index.exprinfo.dim > 0)
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
        it.exprinfo.dim++;
    }

    @Override
    public void visit(newarrayExprNode it) {
        if (!gScope.classes.containsKey(it.type.name))
            throw new semanticError("undefined type", it.pos);
        it.exprinfo = new Exprinfo(it.type.pos, it.type, true, false);
        it.exprinfo.dim = it.getdim();
        it.arrayinitial.accept(this);
        if (it.arrayinitial.exprinfo.dim != it.exprinfo.dim - 1)
            throw new semanticError("array initial dimension error", it.pos);
        for (var cd : it.size) {
            cd.accept(this);
            if (!cd.exprinfo.isInt || cd.exprinfo.dim > 0)
                throw new semanticError("initial size should be an integer", it.pos);
        }
    }

    @Override
    public void visit(newvarExprNode it) {
        if (!gScope.classes.containsKey(it.type.name))
            throw new semanticError("undefined type", it.pos);
    }

    @Override
    public void visit(memberExprNode it) {
        it.name.accept(this);
        if (it.exprinfo.dim > 0)
            throw new semanticError("", it.pos);
        if (it.exprinfo.isBasic())
            throw new semanticError("basic type does not contain member", it.pos);
        if (!gScope.classes.containsKey(it.exprinfo.name))
            throw new semanticError("undefined class", it.pos);
        if (!gScope.classes.get(it.exprinfo.name).member.containsKey(it.Identifier))
            throw new semanticError("undefined member", it.pos);
        Typeinfo type = gScope.classes.get(it.exprinfo.name).member.get(it.Identifier);
        it.exprinfo = new Exprinfo(it.pos, type, true, false);
    }

    @Override
    public void visit(rightExprNode it) {
        it.lhs.accept(this);
        if (it.lhs.exprinfo.isInt && it.lhs.exprinfo.dim == 0)
            it.exprinfo = new Exprinfo(it.lhs.exprinfo);
        else
            throw new semanticError("only integer can perform INC/DEC operation", it.pos);
    }

    @Override
    public void visit(leftExprNode it) {
        it.rhs.accept(this);
        if (it.opCode == leftOpType.Not) {
            if (it.rhs.exprinfo.isBool && it.rhs.exprinfo.dim == 0)
                it.exprinfo = new Exprinfo(it.rhs.exprinfo);
            else
                throw new semanticError("only boolean can perform NOT operation", it.pos);
        } else {
            if (it.rhs.exprinfo.isInt && it.rhs.exprinfo.dim == 0)
                it.exprinfo = new Exprinfo(it.rhs.exprinfo);
            else
                throw new semanticError("only integer can perform INC/DEC operation", it.pos);
        }
    }

    @Override
    public void visit(literalExprNode it) {
        it.exprinfo.isLvalue = false;
        it.exprinfo.dim = 0;
        if (it instanceof intExprNode)
            it.exprinfo.isInt = true;
        if (it instanceof boolExprNode)
            it.exprinfo.isBool = true;
        if (it instanceof nullExprNode)
            it.exprinfo.isNull = true;
        if (it instanceof conststrExprNode)
            it.exprinfo.isString = true;
    }

    @Override
    public void visit(atomExprNode it) {
        if (it.str == "this") {
            if (!inClass)
                throw new semanticError("this must be in ", it.pos);
        } else {
            if (gScope.functions.containsKey(it.str)) {
                it.exprinfo.isFunc = true;
                it.exprinfo.name = it.str;
            } else {
                if(scope.containsVariable(it.str, true)){
                    Typeinfo type = scope.getType(it.str, true);
                    it.exprinfo = new Exprinfo(it.pos, type, true, false);
                }else{
                    if (!gScope.classes.containsKey(it.str))
                        throw new semanticError("undefined identifier", it.pos);
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
        it.name.accept(this);
        if (!it.name.exprinfo.isFunc)
            throw new semanticError("undefined function", it.pos);
        if (!gScope.functions.containsKey(it.name.exprinfo.name))
            throw new semanticError("undefined function", it.pos);
        Funcinfo f = gScope.functions.get(it.name.exprinfo.name);
        for (int i = 0; i < it.args.size(); i++) {
            it.args.get(i).accept(this);
            if (!f.argtype.get(i).equal(it.args.get(i).exprinfo.type))
                throw new semanticError("function arguments type mismatch", it.pos);
        }
        it.exprinfo = new Exprinfo(it.pos, f.type, false, false);
    }

    @Override
    public void visit(ternaryExprNode it) {
        it.cond.accept(this);
        if (!it.cond.exprinfo.isBool || it.cond.exprinfo.dim > 0)
            throw new semanticError("condition must be a boolean expression", it.pos);
        it.thenstmt.accept(this);
        it.elsestmt.accept(this);
        if (it.thenstmt.exprinfo.type.equal(it.elsestmt.exprinfo.type))
            throw new semanticError("thenstmt type mismatch elsestmt type", it.pos);
        it.exprinfo = new Exprinfo(it.thenstmt.exprinfo);
    }

    @Override
    public void visit(ifStmtNode it) {
        it.condition.accept(this);
        if (!it.condition.exprinfo.isBool || it.condition.exprinfo.dim > 0)
            throw new semanticError("condition must be a boolean expression", it.pos);
        Scope s = scope;
        scope = new Scope(s);
        it.thenStmt.accept(this);
        scope = new Scope(s);
        if (it.elseStmt != null)
            it.elseStmt.accept(this);
        out();
    }

    @Override
    public void visit(forStmtNode it) {
        if (it.condition != null){
            it.condition.accept(this);
            if (!it.condition.isexpr)
                throw new semanticError("condition must be a boolean expression", it.pos);
            if (!it.condition.exprinfo.isBool || it.condition.exprinfo.dim > 0)
                throw new semanticError("condition must be a boolean expression", it.pos);
        }
        it.initStmt.accept(this);
        if (it.step != null)
            it.step.accept(this);
        scope = new Scope(scope);
        loop++;
        it.bodyStmt.accept(this);
        loop--;
        out();
    }

    @Override
    public void visit(returnStmtNode it) {
        if (!(scope instanceof FuncScope))
            throw new semanticError("return statement must be in function", it.pos);
        if (it.value!=null){
            it.value.accept(this);
            if(!it.value.exprinfo.type.equal(((FuncScope)scope).retType))
                throw new semanticError("return type mismatch", it.pos);
        }else{
            if(((FuncScope)scope).retType.isVoid == false)
                throw new semanticError("return type mismatch", it.pos);
        }
    }

    @Override
    public void visit(suiteStmtNode it) {
        scope = new Scope(scope);
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
        if (!it.condition.exprinfo.isBool||it.condition.exprinfo.dim>0)
            throw new semanticError("condition must be a boolean expression", it.pos);
        scope = new Scope(scope);
        loop++;
        it.bodyStmt.accept(this);
        loop--;
        out();
    }

    @Override
    public void visit(jumpStmtNode it) {
        if (loop==0)
            throw new semanticError("jump must be in loop", it.pos);
    }

    @Override
    public void visit(exprStmtNode it) {
        it.isexpr = true;
        it.expr.accept(this);
        it.exprinfo = new Exprinfo(it.expr.exprinfo);
    }
}
