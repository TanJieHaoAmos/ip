package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.Task;
import runny.task.TaskList;
import runny.task.Todo;
import runny.ui.Ui;

public class TodoCommand implements Command {
    private String details;

    public TodoCommand(String details) {
        this.details = details;
    }

    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) throws RunnyException {
        if (details == "") {
            throw new RunnyException("OOPS!!! The description of a todo cannot be empty.\n");
        }
        Task currentTask = new Todo(details);
        tasks.add(currentTask);
        storage.writeToFile(tasks);
        ui.printMessage("Got it. I've added this runny.task:\n" + currentTask.toString() + "\nNow you have "
                + tasks.size() + " tasks in the list.");
    }

    @Override
    public void loadTask(TaskList tasks) {
        Task curr = new Todo(details);
        tasks.add(curr);
    }

    @Override
    public boolean endProgram() {
        return false;
    }
}
