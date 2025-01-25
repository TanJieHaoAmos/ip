package runny.ui;

import java.util.Scanner;

public class Ui {
    private static Scanner scanner = new Scanner(System.in);
    private static final String line = "____________________________________________________________\n";

    private String makeLine(String message) {
        return line + message + "\n" + line;
    }

    public String processCommand() {
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(makeLine(message));
    }

    public void welcomeMessage() {
        printMessage("Hello! I'm RunnyTalky\nWhat can I do for you?");
    }

    public void byeMessage() {
        printMessage("Goodbye! Hope to see you again soon :)");
    }

}
