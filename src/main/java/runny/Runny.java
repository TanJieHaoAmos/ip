package runny;

import runny.commands.Command;
import runny.parser.Parser;
import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

public class Runny {

    private Storage storage;
    private TaskList tasks = new TaskList();
    private Ui ui;

    public Runny(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        ui.welcomeMessage();
        try {
            this.tasks = this.storage.load();
        } catch (RunnyException e) {
            ui.printMessage(e.getMessage());
            this.tasks = new TaskList();
        }
    }

    public void run() {

        boolean endProgram = false;
        while(!endProgram) {
            try {
                String fullCommand = ui.processCommand();
                Command c = Parser.parse(fullCommand);
                c.doCommand(ui, storage, tasks);
                endProgram = c.endProgram();
            } catch (RunnyException e) {
                ui.printMessage(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Runny("./data/duke.txt").run();
    }
}
