package runny.commands;

import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

public class FindCommand implements Command {

    private String details;

    public FindCommand(String details) {
        this.details = details;
    }


    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) {
        String output = "Here are the matching tasks in your list:";
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(details)) {
                output += "\n" + (i + 1) + "." + tasks.get(i).toString();
            }
        }
        ui.printMessage(output.toString());
    }

    @Override
    public void loadTask(TaskList tasks) {

    }

    @Override
    public boolean endProgram() {
        return false;
    }


}
