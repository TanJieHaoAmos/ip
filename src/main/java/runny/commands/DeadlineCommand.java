package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.Deadline;
import runny.task.Task;
import runny.task.TaskList;
import runny.ui.Ui;

public class DeadlineCommand implements Command {
    private String details;

    public DeadlineCommand(String details) {
        this.details = details;
    }

    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) throws RunnyException {
        if (details == "") {
            throw new RunnyException("OOPS!!! The description of a deadline cannot be empty.\n");
        }
        if (!details.contains("/by")) {
            throw new RunnyException("OOPS!!! The format for your given command is wrong.\n");
        }
        String[] deadlineFront = details.split("/by");
        Task currentTask = new Deadline(deadlineFront[0], deadlineFront[1].trim());
        tasks.add(currentTask);
        storage.writeToFile(tasks);
        ui.printMessage("Got it. I've added this runny.task:\n" + currentTask.toString() +
                "\nNow you have " + Integer.toString(tasks.size()) + " tasks in the list.");
    }

    @Override
    public void loadTask(TaskList tasks) {
        String[] partDeadline = details.split("/by");
        Task curr = new Deadline(partDeadline[0], partDeadline[1].trim());
        tasks.add(curr);
    }

    @Override
    public boolean endProgram() {

        return false;
    }
}
