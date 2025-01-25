package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.Task;
import runny.task.TaskList;
import runny.ui.Ui;

/**
 * Determines the task index to be deleted.
 */
public class DeleteCommand implements Command {
    private String details;

    /**
     * Creates a DeleteCommand with the specified details.
     *
     * @param details The details of the task index to be deleted.
     */
    public DeleteCommand(String details) {
        this.details = details;
    }

    /**
     * Executes command by removing a task from the task list.
     * Displays relevant messages to the user.
     *
     * @param ui      The user interface for displaying messages.
     * @param storage The storage for saving task data after modification.
     * @param tasks   The list of tasks.
     * @throws RunnyException If the task index is out of bounds.
     */
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

    /**
     * Does nothing.
     *
     * @param tasks The list of tasks.
     */
    @Override
    public void loadTask(TaskList tasks) {

    }

    /**
     * Indicates that this command is not an exit command.
     *
     * @return `false` indicating that the application should not exit.
     */
    @Override
    public boolean endProgram() {
        return false;
    }
}
