package baseball.port.outbound;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class StandardOutput {

    public static void print(final Object message) {
        System.out.print(message);
    }

    public static void println(final Object message) {
        System.out.println(message);
    }
}
