package Util.error;
import Util.scope.position;

public class syntaxError extends error {

    public syntaxError(String msg, position pos) {
        super("SyntaxError: " + msg, pos);
    }

}
