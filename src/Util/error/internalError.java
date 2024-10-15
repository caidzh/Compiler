package Util.error;
import Util.scope.position;

public class internalError extends error {

    public internalError(String msg, position pos) {
        super("Internal Error:" + msg, pos);
    }

}
