package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

/**
 * Searches through the task list and displays tasks containing the keyword.
 */
public class FindCommand implements Command {

    private String details;

    /**
     * Creates a FindCommand with the specified keyword details.
     *
     * @param details The keyword to search for in the task names.
     */
    public FindCommand(String details) {
        this.details = details;
    }

    /**
     * Executes command by searching and displaying tasks containing the keyword.
     * Displays the matching tasks to the user.
     *
     * @param ui      The user interface for displaying messages.
     * @param storage The storage.
     * @param tasks   The list of tasks.
     */
    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) {
        assert ui != null && storage != null && tasks != null : "One of the three objects, "
                + "ui,storage or tasks is null";
        String output = "Here are the matching tasks in your list:";
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(details)) {
                output += "\n" + (i + 1) + "." + tasks.get(i).toString();
            }
        }
        ui.printMessage(output.toString());
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
     * Does nothing.
     *
     * @param tasks The list of tasks.
     * @return The command to be executed.
     * @throws RunnyException If an error occurs during command execution.
     */
    @Override
    public Command undoTask(TaskList tasks) throws RunnyException {
        return new BlankCommand();
    }



}
