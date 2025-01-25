package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.Task;
import runny.task.TaskList;
import runny.ui.Ui;

public class MarkCommand implements Command {
    private String details;

    public MarkCommand(String details) {
        this.details = details;
    }

    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) throws RunnyException {
        int markIndex = Integer.parseInt(details) - 1;
        if (markIndex >= tasks.size() || markIndex < 0) {
            throw new RunnyException("OOPS!!! The specified runny.task to mark is out of range.");
        }
        Task currentTask = tasks.get(markIndex);
        currentTask.markTask();
        storage.writeToFile(tasks);
        ui.printMessage("Nice! I've marked this runny.task as done:\n" + currentTask.toString());
    }

    @Override
    public void loadTask(TaskList tasks) {

    }

    @Override
    public boolean endProgram() {
        return false;
    }
}
