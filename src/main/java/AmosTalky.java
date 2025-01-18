public class AmosTalky {
    String line = "____________________________________________________________\n";

    public String welcomeMessage() {
        return line + "Hello! I'm AmosTalky\nWhat can I do for you?\n" + line;
    }

    public String byeMessage() {
        return line + "Bye. Hope to see you again soon!\n" + line;

    }

    public String echoMessage(String message) {
        return line + message + "\n" + line;
    }
}
