public class AmosTalky {
    private static final String line = "____________________________________________________________\n";
    private static String[] itemsList = new String[100];
    private static int itemCount = 0;

    private String addLine(String message) {
        return line + message + "\n" + line;
    }
    private String welcomeMessage() {
        return "Hello! I'm AmosTalky\nWhat can I do for you?";
    }

    private String byeMessage() {
        return "Bye. Hope to see you again soon!";

    }

    private String storeTask(String task) {
        itemsList[itemCount] = task;
        itemCount++;
        return addLine("added: " + task);
    }

    private String printTasks() {
        String output = "";
        for (int i = 0; i < itemCount; i++) {
            if (!itemsList[i].isEmpty()) {
                output += (i + 1) + ". " + itemsList[i] + "\n";
            }
        }
        return output;
    }

    public String messageAction(String keyword) {
        switch (keyword) {
            case "start":
                return addLine(welcomeMessage());
            case "bye":
                return addLine(byeMessage());
            case "list":
                return printTasks() + line;
            default:
                return storeTask(keyword);
        }
    }
}
