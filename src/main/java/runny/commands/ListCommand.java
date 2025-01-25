package runny.commands;

import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

public class ListCommand implements Command {
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

    @Override
    public void loadTask(TaskList tasks) {

    }

    @Override
    public boolean endProgram() {
        return false;
    }
}
