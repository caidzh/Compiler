package Frontend;

import AST.*;
import AST.DefNode.*;
import AST.ExprNode.*;
import AST.StmtNode.*;
import AST.StmtNode.jumpStmtNode.jumpType;
import AST.ExprNode.leftExprNode.leftOpType;
import AST.ExprNode.rightExprNode.rightOpType;
import AST.ExprNode.binaryOpExprNode.binaryOpType;
import AST.ExprNode.binaryCmpExprNode.binaryCmpType;
import org.antlr.v4.runtime.tree.TerminalNode;
import Util.info.*;
import Grammar.MxBaseVisitor;
import Grammar.MxParser;
import Util.position;
import Util.error.semanticError;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.lang.Integer;

public class ASTBuilder extends MxBaseVisitor<ASTNode> {

    public ASTBuilder() {

    }

    Typeinfo intType, boolType;

    @Override
    public ASTNode visitProgram(MxParser.ProgramContext ctx) {
        RootNode root = new RootNode(new position(ctx));
        ctx.children.forEach(cd -> {
            if (!(cd instanceof TerminalNode)) {
                root.Defs.add((DefNode) visit(cd));
            }
        });
        return root;
    }

    @Override
    public ASTNode visitClassDef(MxParser.ClassDefContext ctx) {
        classDefNode classDef = new classDefNode(new position(ctx), ctx.Identifier().getText().toString());
        ctx.varDef().forEach(cd -> classDef.Defs.add((DefNode) visit(cd)));
        ctx.funcDef().forEach(cd -> classDef.Defs.add((DefNode) visit(cd)));
        if (ctx.classConstruct().size() > 1)
            throw new semanticError("Number of classconstruct function is more than 1",
                    new position(ctx.classConstruct(0)));
        if (ctx.classConstruct().size() > 0 && !ctx.classConstruct(0).Identifier().getText().equals(classDef.name))
            throw new semanticError("classconstruct function name doesn't match class name",
                    new position(ctx.classConstruct(0)));
        if (ctx.classConstruct().size() > 0)
            classDef.constructor = (suiteStmtNode) visit(ctx.classConstruct(0));
        return classDef;
    }

    @Override
    public ASTNode visitVarDef(MxParser.VarDefContext ctx) {
        Typeinfo type = new Typeinfo(ctx.typename());
        ArrayList<varDefNode> Defs = new ArrayList<>();
        ctx.argvar().forEach(cd -> Defs.add((varDefNode) visit(cd)));
        return new varDefsNode(type, Defs, new position(ctx));
    }

    @Override
    public ASTNode visitFuncDef(MxParser.FuncDefContext ctx) {
        funcDefNode funcDef = new funcDefNode(new position(ctx), ctx.name.getText().toString(),
                new Typeinfo(ctx.typename()));
        if (ctx.arglist() != null)
            ctx.arglist().arg().forEach(cd -> funcDef.args.add((varDefsNode) visit(cd)));
        funcDef.body = (suiteStmtNode) visit(ctx.body);
        return funcDef;
    }

    @Override
    public ASTNode visitArg(MxParser.ArgContext ctx) {
        Typeinfo type = new Typeinfo(ctx.typename());
        ArrayList<varDefNode> Defs = new ArrayList<>();
        Defs.add((varDefNode) visit(ctx.argvar()));
        return new varDefsNode(type, Defs, new position(ctx));
    }

    @Override
    public ASTNode visitArgvar(MxParser.ArgvarContext ctx) {
        varDefNode varDef = new varDefNode(ctx.name.getText().toString(), new position(ctx));
        if (ctx.expression() != null)
            varDef.init = (ExprNode) visit(ctx.expression());
        return varDef;
    }

    @Override
    public ASTNode visitSuite(MxParser.SuiteContext ctx) {
        suiteStmtNode node = new suiteStmtNode(new position(ctx));
        if (!ctx.statement().isEmpty()) {
            for (ParserRuleContext stmt : ctx.statement()) {
                StmtNode tmp = (StmtNode) visit(stmt);
                if (tmp != null)
                    node.stmts.add(tmp);
            }
        }
        return node;
    }

    @Override
    public ASTNode visitIfStmt(MxParser.IfStmtContext ctx) {
        StmtNode thenStmt = (StmtNode) visit(ctx.thenstmt), elseStmt = null;
        ExprNode condition = (ExprNode) visit(ctx.cond);
        if (ctx.elsestmt != null)
            elseStmt = (StmtNode) visit(ctx.elsestmt);
        return new ifStmtNode(condition, thenStmt, elseStmt, new position(ctx));
    }

    @Override
    public ASTNode visitReturnStmt(MxParser.ReturnStmtContext ctx) {
        ExprNode value = null;
        if (ctx.expression() != null)
            value = (ExprNode) visit(ctx.expression());
        return new returnStmtNode(value, new position(ctx));
    }

    @Override
    public ASTNode visitVarDefStmt(MxParser.VarDefStmtContext ctx) {
        varDefsNode it;
        it = (varDefsNode) visit(ctx.varDef());
        return new varDefStmtNode(it, new position(ctx));
    }

    @Override
    public ASTNode visitForStmt(MxParser.ForStmtContext ctx) {
        StmtNode init = (StmtNode) visit(ctx.init), cond = (StmtNode) visit(ctx.cond),
                body = (StmtNode) visit(ctx.body);
        ExprNode step = null;
        if (ctx.step != null)
            step = (ExprNode) visit(ctx.step);
        return new forStmtNode(init, cond, step, body, new position(ctx));
    }

    @Override
    public ASTNode visitWhileStmt(MxParser.WhileStmtContext ctx) {
        ExprNode cond = (ExprNode) visit(ctx.cond);
        StmtNode body = (StmtNode) visit(ctx.body);
        return new whileStmtNode(cond, body, new position(ctx));
    }

    @Override
    public ASTNode visitJumpStmt(MxParser.JumpStmtContext ctx) {
        jumpType jump = null;
        jump = ctx.Continue() != null ? jumpType.Continue : null;
        jump = ctx.Break() != null ? jumpType.Break : null;
        return new jumpStmtNode(jump, new position(ctx));
    }

    @Override
    public ASTNode visitPureExprStmt(MxParser.PureExprStmtContext ctx) {
        return new exprStmtNode((ExprNode) visit(ctx.expression()), new position(ctx));
    }

    @Override
    public ASTNode visitEmptyStmt(MxParser.EmptyStmtContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitParenExpr(MxParser.ParenExprContext ctx) {
        return (ExprNode) visit(ctx.expression());
    }

    @Override
    public ASTNode visitArrayExpr(MxParser.ArrayExprContext ctx) {
        return new arrayExprNode((ExprNode) visit(ctx.name), (ExprNode) visit(ctx.index), new position(ctx));
    }

    @Override
    public ASTNode visitNewArrayExpr(MxParser.NewArrayExprContext ctx) {
        newarrayExprNode newarray = new newarrayExprNode(new position(ctx), new Typeinfo(ctx.type()));
        if (ctx.arrayinitial() != null)
            newarray.arrayinitial = (arrayinitExprNode) visit(ctx.arrayinitial());
        ctx.array().forEach(cd -> {
            if (cd.expression() != null) {
                newarray.size.add((ExprNode) visit(cd.expression()));
            } else {
                newarray.size.add(null);
            }
        });
        newarray.type.dim = newarray.size.size();
        return newarray;
    }

    @Override
    public ASTNode visitArrayinitial(MxParser.ArrayinitialContext ctx) {
        arrayinitExprNode arrayinit = new arrayinitExprNode(new position(ctx));
        ctx.expressionlist().expression().forEach(cd -> arrayinit.arrayinits.add((ExprNode) visit(cd)));
        return arrayinit;
    }

    @Override
    public ASTNode visitNewVarExpr(MxParser.NewVarExprContext ctx) {
        return new newvarExprNode(new position(ctx), new Typeinfo(ctx.type()));
    }

    @Override
    public ASTNode visitMemberExpr(MxParser.MemberExprContext ctx) {
        return new memberExprNode((ExprNode) visit(ctx.expression()), ctx.Identifier().getText().toString(),
                new position(ctx));
    }

    @Override
    public ASTNode visitFuncExpr(MxParser.FuncExprContext ctx) {
        funcExprNode func = new funcExprNode(new position(ctx), (ExprNode) visit(ctx.expression()));
        if (ctx.expressionlist() != null)
            ctx.expressionlist().expression().forEach(cd -> func.args.add((ExprNode) visit(cd)));
        return func;
    }

    @Override
    public ASTNode visitRightExpr(MxParser.RightExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expression());
        rightOpType rOp = null;
        rOp = ctx.Inc() != null ? rightOpType.Inc : rOp;
        rOp = ctx.Dec() != null ? rightOpType.Dec : rOp;
        return new rightExprNode(lhs, rOp, new position(ctx));
    }

    @Override
    public ASTNode visitLeftExpr(MxParser.LeftExprContext ctx) {
        ExprNode rhs = (ExprNode) visit(ctx.expression());
        leftOpType lOp = null;
        lOp = ctx.Inc() != null ? leftOpType.Inc : lOp;
        lOp = ctx.Dec() != null ? leftOpType.Dec : lOp;
        lOp = ctx.Not() != null ? leftOpType.Not : lOp;
        lOp = ctx.BitNot() != null ? leftOpType.BitNot : lOp;
        lOp = ctx.Sub() != null ? leftOpType.Sub : lOp;
        return new leftExprNode(rhs, lOp, new position(ctx));
    }

    @Override
    public ASTNode visitAtomExpr(MxParser.AtomExprContext ctx) {
        return new atomExprNode(ctx.getText(), new position(ctx));
    }

    @Override
    public ASTNode visitBinaryOpExpr(MxParser.BinaryOpExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expression(0)),
                rhs = (ExprNode) visit(ctx.expression(1));
        binaryOpType biOp = null;
        biOp = ctx.Add() != null ? binaryOpType.Add : biOp;
        biOp = ctx.Sub() != null ? binaryOpType.Sub : biOp;
        biOp = ctx.Mul() != null ? binaryOpType.Mul : biOp;
        biOp = ctx.Div() != null ? binaryOpType.Div : biOp;
        biOp = ctx.Mod() != null ? binaryOpType.Mod : biOp;
        biOp = ctx.BitAnd() != null ? binaryOpType.BitAnd : biOp;
        biOp = ctx.BitXor() != null ? binaryOpType.BitXor : biOp;
        biOp = ctx.BitOr() != null ? binaryOpType.BitOr : biOp;
        biOp = ctx.And() != null ? binaryOpType.And : biOp;
        biOp = ctx.Or() != null ? binaryOpType.Or : biOp;
        biOp = ctx.LeftShift() != null ? binaryOpType.LeftShift : biOp;
        biOp = ctx.RightShift() != null ? binaryOpType.RightShift : biOp;
        return new binaryOpExprNode(lhs, rhs, biOp, new position(ctx));
    }

    @Override
    public ASTNode visitBinaryCmpExpr(MxParser.BinaryCmpExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expression(0)),
                rhs = (ExprNode) visit(ctx.expression(1));
        binaryCmpType biOp = null;
        biOp = ctx.Ge() != null ? binaryCmpType.Ge : biOp;
        biOp = ctx.Le() != null ? binaryCmpType.Le : biOp;
        biOp = ctx.Geq() != null ? binaryCmpType.Geq : biOp;
        biOp = ctx.Leq() != null ? binaryCmpType.Leq : biOp;
        biOp = ctx.Neq() != null ? binaryCmpType.Neq : biOp;
        biOp = ctx.Eq() != null ? binaryCmpType.Eq : biOp;

        return new binaryCmpExprNode(lhs, rhs, biOp, new position(ctx));
    }

    @Override
    public ASTNode visitTernaryExpr(MxParser.TernaryExprContext ctx) {
        ExprNode cond = (ExprNode) visit(ctx.expression(0)),
                thenstmt = (ExprNode) visit(ctx.expression(1)),
                elsestmt = (ExprNode) visit(ctx.expression(2));
        return new ternaryExprNode(cond, thenstmt, elsestmt, new position(ctx));
    }

    @Override
    public ASTNode visitAssignExpr(MxParser.AssignExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expression(0)),
                rhs = (ExprNode) visit(ctx.expression(1));
        return new assignExprNode(lhs, rhs, new position(ctx));
    }

    @Override
    public ASTNode visitArrayInitExpr(MxParser.ArrayInitExprContext ctx) {
        return (arrayinitExprNode) visit(ctx.arrayinitial());
    }

    @Override
    public ASTNode visitFormatStringExpr(MxParser.FormatStringExprContext ctx) {
        formatstringExprNode fstr = new formatstringExprNode(new position(ctx));
        if (ctx.formstr().FormatString() != null)
            fstr.str.add(ctx.formstr().FormatString().getText());
        else {
            fstr.str.add(ctx.formstr().FormatStringL().getText());
            fstr.expr.add((ExprNode) visit(ctx.formstr().expression(0)));
            if (ctx.formstr().FormatStringM() != null) {
                for (int i=0;i<ctx.formstr().FormatStringM().size();i++){
                    fstr.str.add(ctx.formstr().FormatStringM(i).getText());
                    fstr.expr.add((ExprNode) visit(ctx.formstr().expression(i+1)));
                }
            }
            fstr.str.add(ctx.formstr().FormatStringR().getText());
        }
        return fstr;
    }

    @Override
    public ASTNode visitLiteral(MxParser.LiteralContext ctx) {
        if (ctx.False() != null)
            return new boolExprNode(false, new position(ctx));
        else if (ctx.True() != null)
            return new boolExprNode(true, new position(ctx));
        else if (ctx.Null() != null)
            return new nullExprNode(new position(ctx));
        else if (ctx.ConstString() != null)
            return new conststrExprNode(ctx.ConstString().toString(), new position(ctx));
        else
            return new intExprNode(Integer.parseInt(ctx.DecimalInteger().getText()), new position(ctx));
    }

}
