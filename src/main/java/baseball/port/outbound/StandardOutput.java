package baseball.port.outbound;

import javax.naming.OperationNotSupportedException;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class StandardOutput {
    private StandardOutput() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("can not supported initiate Instance.");
    }

    public static void print(final Object message) {
        System.out.print(message);
    }

    public static void println(final Object message) {
        System.out.println(message);
    }
}
