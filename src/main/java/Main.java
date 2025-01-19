import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AmosTalky chat = new AmosTalky();
        Scanner scanner = new Scanner(System.in);
        String commandWord = "start";
        while (true) {
            if (commandWord.equals("bye")) {
                System.out.println(chat.messageAction("bye"));
                break;
            } else {
                    System.out.println((chat.messageAction(commandWord)));
                    commandWord = scanner.nextLine();
            }
        }
        scanner.close();
    }
}
