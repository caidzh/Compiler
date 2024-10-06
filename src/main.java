import Grammar.MxLexer;
import Grammar.MxParser;
import Util.MxErrorListener;
import Util.error.error;
import Util.globalScope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.semantics.SymbolCollector;

import java.io.FileInputStream;
import java.io.InputStream;

public class main {

    public static void main(String[] args) throws Exception{

        String name = "test.mx";
        InputStream input = new FileInputStream(name);

        try {
            RootNode ASTRoot;
            globalScope gScope = new globalScope(null);

            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser MxGrammar = new MxParser(new CommonTokenStream(lexer));
            MxGrammar.removeErrorListeners();
            MxGrammar.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = MxGrammar.program();
            ASTBuilder astBuilder = new ASTBuilder(gScope);
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