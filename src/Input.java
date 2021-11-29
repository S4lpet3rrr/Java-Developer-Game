import java.util.Scanner;

public class Input {
    private Input() {}
    private static Scanner scanner = null;

    public static Scanner get() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return Input.scanner;
    }

    public static String nextLine() {
        return Input.get().nextLine();
    }
}
