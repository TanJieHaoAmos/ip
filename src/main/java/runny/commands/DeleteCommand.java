package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.Task;
import runny.task.TaskList;
import runny.ui.Ui;

public class DeleteCommand implements Command {
    private String details;

    public DeleteCommand(String details) {
        this.details = details;
    }

    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) throws RunnyException {
        int deleteIndex = Integer.parseInt(details) - 1;
        if (details == "") {
            throw new RunnyException("OOPS!!! The description of a delete command cannot be empty.\n");
        }

        if (deleteIndex >= tasks.size() || deleteIndex < 0) {
            throw new RunnyException("OOPS!!! The specified runny.task to delete is out or range.");
        }
        Task currentTask = tasks.get(deleteIndex);
        tasks.remove(currentTask);
        storage.writeToFile(tasks);
        ui.printMessage("Noted. I've removed this runny.task:\n" + currentTask.toString()
                + "\nNow you have " + Integer.toString(tasks.size()) + " tasks in the list.");
    }

    @Override
    public void loadTask(TaskList tasks) {

    }

    @Override
    public boolean endProgram() {
        return false;
    }
}
