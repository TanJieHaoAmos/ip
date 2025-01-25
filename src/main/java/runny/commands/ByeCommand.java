package runny.commands;

import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

/**
 * Displays a goodbye message
 * The application exits after this commands is executed.
 */

public class ByeCommand implements Command {

    /**
     * Executes command by displaying a farewell message to the user.
     *
     * @param ui      user interface for interacting with users.
     * @param storage The storage for writing and reading data.
     * @param tasks   The list of tasks.
     */
    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) {
        ui.byeMessage();
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
     * Indicates that the command is an exit command.
     *
     * @return `true` which tells the application to exit.
     */

    @Override
    public boolean endProgram() {

        return true;
    }
}
