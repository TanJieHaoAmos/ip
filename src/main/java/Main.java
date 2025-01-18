import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AmosTalky chat = new AmosTalky();
        System.out.println(chat.welcomeMessage());
        Scanner scanner = new Scanner(System.in);
        String commandWord = scanner.nextLine();
        while (true) {
            if (commandWord.equals("bye") || commandWord.equals("Bye")) {
                System.out.println(chat.byeMessage());

                break;
            } else {
                System.out.println((chat.echoMessage(commandWord)));
                commandWord = scanner.nextLine();
            }
        }
        scanner.close();
    }
}
