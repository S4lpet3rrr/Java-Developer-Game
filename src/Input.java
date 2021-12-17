import java.util.Scanner;

public class Input {
    private Input() {}
    private static Scanner scanner = null;
/**
 * implementiert scanner, dient dem user als inputmethode
 */
    public static Scanner get() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return Input.scanner;
    }
/**
 * speichert scanner input
 */
    public static String nextLine() {
        return Input.get().nextLine();
    }
}
