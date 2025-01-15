import Grammar.MxLexer;
import Grammar.MxParser;
import Util.error.MxErrorListener;
import Util.error.error;
import Util.scope.globalScope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import AST.*;
import Frontend.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class main {

    public static void main(String[] args) throws Exception{
        var input = CharStreams.fromStream(System.in);
        // String name = "test.mx";
        // InputStream input = new FileInputStream(name);

        try {
            RootNode ASTRoot;
            globalScope gScope = new globalScope(null);

            // MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            MxLexer lexer = new MxLexer(input);

            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser MxGrammar = new MxParser(new CommonTokenStream(lexer));
            MxGrammar.removeErrorListeners();
            MxGrammar.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = MxGrammar.program();
            ASTBuilder astBuilder = new ASTBuilder();
            ASTRoot = (RootNode)astBuilder.visit(parseTreeRoot);
            new SymbolCollector(gScope).visit(ASTRoot);
            new SemanticChecker(gScope).visit(ASTRoot);

            // mainFn f = new mainFn();
            // new IRBuilder(f, gScope).visit(ASTRoot);
            // new IRPrinter(System.out).visitFn(f);

            // AsmFn asmF = new AsmFn();
            // new InstSelector(asmF).visitFn(f);
            // new RegAlloc(asmF).work();
            // new AsmPrinter(asmF, System.out).print();
        } catch (error er) {
            System.out.println(er.toString());
            throw new RuntimeException();
        }
    }
}
