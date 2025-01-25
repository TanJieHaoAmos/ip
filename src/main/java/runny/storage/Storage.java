package runny.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import runny.RunnyException;
import runny.commands.Command;
import runny.parser.Parser;
import runny.task.Task;
import runny.task.TaskList;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public TaskList load() throws RunnyException {
        TaskList list = new TaskList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String currLine;
            while ((currLine = reader.readLine()) != null && !currLine.isEmpty()) {
                String[] currentLine = currLine.split(" ", 2);
                String done = currentLine[0];
                String command = currentLine[1];
                Command c = Parser.parse(command);
                c.loadTask(list);
                if (done.equals("1")) {
                    list.get(list.size() - 1).markTask();
                }
            }
            return list;
        } catch (FileNotFoundException e) {
            File newFile = new File(filePath);
            return list;
        } catch (IOException e) {
            throw new RunnyException("OOPS!! I am unable to load the data in the specified file.");
        }
    }

    public void writeToFile(TaskList taskList) throws RunnyException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false));
            for (Task t : taskList) {
                writer.write(t.save() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RunnyException("Unable to write to file");
        }
    }
}
