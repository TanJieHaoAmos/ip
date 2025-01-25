package runny.commands;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ByeCommandTest {
    @Test
    public void testIsExit() {
        ByeCommand testByeCommand = new ByeCommand();
        assertTrue(testByeCommand.endProgram());
    }
}