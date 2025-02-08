package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.Task;
import runny.task.TaskList;
import runny.task.Todo;
import runny.ui.Ui;

/**
 * Adds a new Todo task to the task list.
 */
public class TodoCommand implements Command {
    private String details;

    /**
     * Creates a TodoCommand with the specified details.
     *
     * @param details The details of the todo task.
     */
    public TodoCommand(String details) {
        this.details = details;
    }

    /**
     * Executes command by creating and adding a Todo tasks to the task list.
     * Displays relevant messages to the user.
     *
     * @param ui      The user interface for displaying messages.
     * @param storage The storage for saving task data after modification.
     * @param tasks   The list of tasks.
     * @throws RunnyException If the task index is out of bounds.
     */
    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) throws RunnyException {
        assert ui != null && storage != null && tasks != null : "One of the three objects, " +
                "ui,storage or tasks is null";
        if (details == "") {
            throw new RunnyException("OOPS!!! The description of a todo cannot be empty.\n");
        }
        Task currentTask = new Todo(details);
        tasks.add(currentTask);
        storage.writeToFile(tasks);
        ui.printMessage("Got it. I've added this runny.task:\n" + currentTask.toString() + "\nNow you have "
                + tasks.size() + " tasks in the list.");
    }

    /**
     * Loads the todo task from the command details and adds it to the task list.
     *
     * @param tasks The list of tasks to which the new task will be added.
     */
    @Override
    public void loadTask(TaskList tasks) {
        Task curr = new Todo(details);
        tasks.add(curr);
    }


}
