package runny;

import java.time.DateTimeException;

import runny.commands.Command;
import runny.parser.Parser;
import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

/**
 * The main class for the chatbot application.
 * Runny is a chatbot that helps to manage tasks;
 * Some things that it can do includes adding todo, events, deadlines.
 * It can also delete and find tasks as well as mark and unmark tasks.
 */

public class Runny {

    private Storage storage;
    private TaskList tasks = new TaskList();
    private Ui ui;

    /**
     * Creates a Runny instance with the provided file path.
     *
     * @param filePath The file path for storing task data.
     */

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

    /**
     * Runs the chatbot
     * Displays a welcome messages
     * Processes user commands.
     */
    public void run() {

        boolean endProgram = false;
        while (!endProgram) {
            try {
                String fullCommand = ui.processCommand();
                Command c = Parser.parse(fullCommand);
                c.doCommand(ui, storage, tasks);
                endProgram = c.endProgram();
            } catch (RunnyException | DateTimeException e) {
                ui.printMessage(e.getMessage());
            }
        }
    }

    /**
     * The starting point of Runny chatbot.
     *
     * @param args Command-line arguments.
     */

    public static void main(String[] args) {
        new Runny("./data/duke.txt").run();
    }
}
