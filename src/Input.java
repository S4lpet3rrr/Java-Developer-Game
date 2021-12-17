import java.util.Scanner;

public class Input {
    private Input() {}
    private static Scanner scanner = null;

    /**
     * anwendung des single pattern
     * rückgabe des scanners
     * @return Input.scanner
     */
    public static Scanner get() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return Input.scanner;
    }

    /**
     * nextline gibt einen String zurück
     * @return String
     */
    public static String nextLine() {
        return Input.get().nextLine();
    }
}
