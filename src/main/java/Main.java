import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AmosTalky chat = new AmosTalky();
        Scanner scanner = new Scanner(System.in);
        String command = "start";
        String info = "";

        while (true) {
            if (command.equals("bye")) {
                System.out.println(chat.messageAction("bye", info));
                break;
            } else {
                    System.out.println(chat.messageAction(command, info));
                    String nextCommand = scanner.nextLine();
                    String[] splitCommand = nextCommand.split(" ");
                    command = splitCommand[0];
                    info = "";

                    for (int i = 1; i < splitCommand.length; i++) {
                        info += splitCommand[i];
                        if (i + 1 < splitCommand.length) {
                            info += " ";
                        }
                    }
            }
        }
        scanner.close();
    }
}
