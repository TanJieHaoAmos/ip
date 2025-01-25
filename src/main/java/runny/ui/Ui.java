package runny.ui;

import java.util.Scanner;

/**
 * User interface class responsible for interacting with the user.
 * Provides methods to display messages and read user commands.
 */

public class Ui {
    private static Scanner scanner = new Scanner(System.in);
    private static final String line = "____________________________________________________________\n";

    /**
     * Adds horizontal lines to the provided message for better formatting.
     *
     * @param message The message to which horizontal lines are added.
     * @return The formatted message with horizontal lines added.
     */
    private String makeLine(String message) {
        return line + message + "\n" + line;
    }

    /**
     * Processes a command entered by the user.
     *
     * @return The user's input command.
     */
    public String processCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays a message to the user.
     *
     * @param message The message to be displayed.
     */
    public void printMessage(String message) {
        System.out.println(makeLine(message));
    }

    /**
     * Displays a welcome message to the user.
     */
    public void welcomeMessage() {
        printMessage("Hello! I'm RunnyTalky\nWhat can I do for you?");
    }

    /**
     * Displays an exit message to the user.
     */
    public void byeMessage() {
        printMessage("Goodbye! Hope to see you again soon :)");
    }

}
