public class AmosTalky {
    private static final String line = "____________________________________________________________\n";
    private static Task[] itemsList = new Task[100];
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
        itemsList[itemCount] = new Task(task);
        itemCount++;
        return addLine("added: " + task);
    }

    private String printTasks() {
        String output = "";
        for (int i = 0; i < itemCount; i++) {
            if (itemsList[i] != null) {
                output += (i + 1) + ". " + itemsList[i].printTask() + "\n";
            }
        }
        return output;
    }

    private String doTask(int index) {
        Task currentTask = itemsList[index - 1];
        currentTask.markTask();
        return "Nice! I've marked this task as done: \n" + currentTask.printTask();
    }

    private String undoTask(int index) {
        Task currentTask = itemsList[index - 1];
        currentTask.unmarkTask();
        return "OK, I've marked this task as not done yet: \n" + currentTask.printTask();
    }


    public String messageAction(String keyword, String details) {
        switch (keyword) {
            case "start":
                return addLine(welcomeMessage());
            case "bye":
                return addLine(byeMessage());
            case "list":
                return addLine(printTasks());
            case "mark":
                return addLine(doTask(Integer.parseInt(details)));
            case "unmark":
                return addLine(undoTask(Integer.parseInt(details)));
            default:
                return storeTask(keyword + " " + details);
        }
    }
}
