package runny.commands;

import runny.RunnyException;
import runny.task.TaskList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TodoCommandTest {
    @Test
    public void missingArgument() {
        assertThrows(RunnyException.class, () -> new TodoCommand("").doCommand(null, null, null));
    }
    @Test
    public void testTodoLoad() {
        TaskList tasks = new TaskList();
        TodoCommand testTodoCommand = new TodoCommand("sell food");
        testTodoCommand.loadTask(tasks);
        assertEquals(1, tasks.size());
    }
}