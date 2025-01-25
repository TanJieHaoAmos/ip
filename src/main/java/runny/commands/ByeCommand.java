package runny.commands;

import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

public class ByeCommand implements Command {

    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) {
        ui.byeMessage();
    }

    @Override
    public void loadTask(TaskList tasks) {

    }

    @Override
    public boolean endProgram() {

        return true;
    }
}
