package runny.commands;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.Event;
import runny.task.Task;
import runny.task.TaskList;
import runny.ui.Ui;

public class EventCommand implements Command {
    private String details;

    public EventCommand(String details) {
        this.details = details;
    }

    @Override
    public void doCommand(Ui ui, Storage storage, TaskList tasks) throws RunnyException {
        if (details == "") {
            throw new RunnyException("OOPS!!! The description of an event cannot be empty.\n");
        }
        if (!details.contains("/from") || !details.contains("/to")) {
            throw new RunnyException("OOPS!!! The format for your given command is wrong.\n");
        }
        String[] eventFront = details.split("/from");
        String[] eventBack = eventFront[1].split(("/to"));
        Task currentTask = new Event(eventFront[0], eventBack[0].trim(), eventBack[1].trim());
        tasks.add(currentTask);
        storage.writeToFile(tasks);
        ui.printMessage("Got it. I've added this runny.task:\n" + currentTask.toString()
                + "\nNow you have " + Integer.toString(tasks.size()) + " tasks in the list.");

    }

    @Override
    public void loadTask(TaskList tasks) {
        String[] eventFront = details.split("/from");
        String[] eventBack = eventFront[1].split(("/to"));
        Task currentTask = new Event(eventFront[0], eventBack[0].trim(), eventBack[1].trim());
        tasks.add(currentTask);
    }

    @Override
    public boolean endProgram() {
        return false;
    }
}
