package runny.commands;

import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

/**
 * Iterates through the task list and displays the tasks.
 */
public class ListCommand implements Command {

    /**
     * Executes command by displaying all the tasks in the task list.
     * Displays the tasks in the list to the user.
     *
     * @param ui      The user interface for displaying messages.
     * @param storage The storage.
     * @param tasks   The list of tasks.
     */
    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) {
        String output = "";
        for (int i = 0; i < tasks.size(); i++) {
            if (!tasks.isEmpty()) {
                output += (i + 1) + ". " + tasks.get(i).toString() + "\n";
            }
        }
        ui.printMessage(output);
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
