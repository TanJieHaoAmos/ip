import java.util.ArrayList;

public class AmosTalky {
    private static final String line = "____________________________________________________________\n";
    private static ArrayList<Task> itemsList = new ArrayList<>();
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
        Task currentTask = new Task(task);
        itemsList.add(currentTask);
        return makeLine("added: " + task);
    }

    private String printTasks() {
        String output = "";
        for (int i = 0; i < itemsList.size(); i++) {
            if (!itemsList.isEmpty()) {
                output += (i + 1) + ". " + itemsList.get(i).toString() + "\n";
            }
        }
        return output;
    }

    private String doTask(int index) {
        Task currentTask = itemsList.get(index - 1);
        currentTask.markTask();
        return "Nice! I've marked this task as done:\n" + currentTask.toString();
    }

    private String undoTask(int index) {
        Task currentTask = itemsList.get(index - 1);
        currentTask.unmarkTask();
        return "OK, I've marked this task as not done yet:\n" + currentTask.toString();
    }

    private String addToDo(String description) {
        Task currentTask= new ToDo(description);
        itemsList.add(currentTask);
        return "Got it. I've added this task:\n" + currentTask.toString() + numberItemsString();
    }

    private String addEvent(String description, String from, String to) {
        Task currentTask = new Event(description, from, to);
         itemsList.add(currentTask);
        return "Got it. I've added this task:\n" + currentTask.toString() + numberItemsString();
    }

    private String addDeadline(String description, String by) {
        Task currentTask = new Deadline(description, by);
        itemsList.add(currentTask);
        return "Got it. I've added this task:\n" + currentTask.toString() + numberItemsString();
    }

    private String numberItemsString() {
        return "\nNow you have " + itemsList.size() + " tasks in the list.";
    }

    private String removeTask(int index) {
        Task currentTask = itemsList.get(index - 1);
        itemsList.remove(currentTask);
        return "Noted. I've removed this task:\n" + currentTask.toString() + numberItemsString();
    }


    public String messageAction(String keyword, String details) {
        try {
            switch (keyword) {
                case "start":
                    return makeLine(welcomeMessage());
                case "bye":
                    return makeLine(byeMessage());
                case "list":
                    return makeLine(printTasks());
                case "mark":
                    int markIndex = Integer.parseInt(details);
                    if (markIndex > itemsList.size()) {
                        throw new RunnyException("OOPS!!! The specified task to mark is out or range.");
                    }
                    return makeLine(doTask(markIndex));
                case "unmark":
                    int unmarkIndex = Integer.parseInt(details);
                    if (unmarkIndex > itemsList.size()) {
                        throw new RunnyException("OOPS!!! The specified task to unmark is out or range.");
                    }
                    return makeLine(undoTask(unmarkIndex));
                case "todo":
                    if (details == "") {
                        throw new RunnyException("OOPS!!! The description of a todo cannot be empty.\n");
                    }
                    return makeLine(addToDo(details));
                case "event":
                    if (details == "") {
                        throw new RunnyException("OOPS!!! The description of an event cannot be empty.\n");
                    }
                    if (!details.contains("/from") || !details.contains("/to")) {
                        throw new RunnyException("OOPS!!! The format for your given command is wrong.\n");
                    }
                    String[] EventFront = details.split("/from");
                    String[] EventBack = EventFront[1].split(("/to"));
                    return makeLine(addEvent(EventFront[0], EventBack[0], EventBack[1]));
                case "deadline":
                    if (details == "") {
                        throw new RunnyException("OOPS!!! The description of a deadline cannot be empty.\n");
                    }
                    if (!details.contains("/by")) {
                        throw new RunnyException("OOPS!!! The format for your given command is wrong.\n");
                    }
                    String[] deadlineFront = details.split("/by");
                    return makeLine(addDeadline(deadlineFront[0], deadlineFront[1]));
                case "delete":
                    if (details == "") {
                        throw new RunnyException("OOPS!!! The description of a delete command cannot be empty.\n");
                    }
                    int deleteIndex = Integer.parseInt(details);
                    if (deleteIndex > itemsList.size() || deleteIndex < 1) {
                        throw new RunnyException("OOPS!!! The specified task to delete is out or range.");
                    }
                    return makeLine(removeTask(deleteIndex));
                default:
                    throw new RunnyException("OOPS!!! I'm sorry, but I do not understand that command :-(\n");
            }
        } catch (RunnyException e) {
            return makeLine(e.toString());
        }
    }
}
