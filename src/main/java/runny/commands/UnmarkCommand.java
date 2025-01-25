package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.Task;
import runny.task.TaskList;
import runny.ui.Ui;

public class UnmarkCommand implements Command {
    private String details;

    public UnmarkCommand(String details) {
        this.details = details;
    }

    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) throws RunnyException {
        int unmarkIndex = Integer.parseInt(details) - 1;
        if (unmarkIndex >= tasks.size() || unmarkIndex < 0) {
            throw new RunnyException("OOPS!!! The specified runny.task to unmark is out or range.");
        }
        Task currentTask = tasks.get(unmarkIndex);
        currentTask.unmarkTask();
        storage.writeToFile(tasks);
        ui.printMessage("OK, I've marked this runny.task as not done yet:\n" + currentTask.toString());
    }

    @Override
    public void loadTask(TaskList tasks) {

    }

    @Override
    public boolean endProgram() {
        return false;
    }
}
