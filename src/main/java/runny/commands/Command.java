package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

public interface Command {

    public void doCommand(Ui ui, Storage storage, TaskList tasks) throws RunnyException;
    public void loadTask(TaskList tasks);
    public boolean endProgram();

}
