package runny.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import runny.RunnyException;
import runny.storage.Storage;
import runny.task.TaskList;
import runny.ui.Ui;

public class UnmarkCommandTest {
    @Test
    public void negativeArgument() {
        assertThrows(RunnyException.class, () -> new UnmarkCommand("-1").doCommand(null, null, new TaskList()));
    }
    @Test
    public void invalidArgument() {
        assertThrows(RunnyException.class, () -> new UnmarkCommand("2").doCommand(null, null, new TaskList()));
    }
    @Test
    public void unmarkTaskTest() throws RunnyException {
        TaskList tasks = new TaskList();
        TodoCommand testUnmarkCommand = new TodoCommand("sell food");
        testUnmarkCommand.loadTask(tasks);
        new UnmarkCommand("1").doCommand(new Ui(), new Storage("./data/testCase.txt"), tasks);
        assertFalse(tasks.get(0).getDone());
        new DeleteCommand("1").doCommand(new Ui(), new Storage("./data/testCase.txt"), tasks);
    }
}
