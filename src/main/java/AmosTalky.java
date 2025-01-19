public class AmosTalky {
    private static final String line = "____________________________________________________________\n";
    private static Task[] itemsList = new Task[100];
    private static int itemCount = 0;

    private String makeLine(String message) {
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
        return makeLine("added: " + task);
    }

    private String printTasks() {
        String output = "";
        for (int i = 0; i < itemCount; i++) {
            if (itemsList[i] != null) {
                output += (i + 1) + ". " + itemsList[i].toString() + "\n";
            }
        }
        return output;
    }

    private String doTask(int index) {
        Task currentTask = itemsList[index - 1];
        currentTask.markTask();
        return "Nice! I've marked this task as done: \n" + currentTask.toString();
    }

    private String undoTask(int index) {
        Task currentTask = itemsList[index - 1];
        currentTask.unmarkTask();
        return "OK, I've marked this task as not done yet: \n" + currentTask.toString();
    }

    private String addToDo(String description) {
        itemsList[itemCount] = new ToDo(description);
        Task currentTask = itemsList[itemCount];
        itemCount++;
        return "Got it. I've added this task: \n" + currentTask.toString() + numberItemsString();
    }

    private String addEvent(String description, String from, String to) {
        itemsList[itemCount] = new Event(description, from, to);
        Task currentTask = itemsList[itemCount];
        itemCount++;
        return "Got it. I've added this task: \n" + currentTask.toString() + numberItemsString();
    }

    private String addDeadline(String description, String by) {
        itemsList[itemCount] = new Deadline(description, by);
        Task currentTask = itemsList[itemCount];
        itemCount++;
        return "Got it. I've added this task: \n" + currentTask.toString() + numberItemsString();
    }

    private String numberItemsString() {
        return "\n Now you have " + itemCount + " tasks in the list.";
    }


    public String messageAction(String keyword, String details) {
        switch (keyword) {
            case "start":
                return makeLine(welcomeMessage());
            case "bye":
                return makeLine(byeMessage());
            case "list":
                return makeLine(printTasks());
            case "mark":
                return makeLine(doTask(Integer.parseInt(details)));
            case "unmark":
                return makeLine(undoTask(Integer.parseInt(details)));
            case "todo":
                return makeLine(addToDo(details));
            case "event":
                String[] EventFront = details.split("/from");
                String[] EventBack = EventFront[1].split(("/to"));
                return makeLine(addEvent(EventFront[0],EventBack[0],EventBack[1]));
            case "deadline":
                String[] deadlineFront = details.split("/by");
                return makeLine(addDeadline(deadlineFront[0],deadlineFront[1]));
            default:
                return storeTask(keyword + " " + details);
        }
    }
}
