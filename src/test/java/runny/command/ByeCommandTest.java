package runny.commands;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ByeCommandTest {
    @Test
    public void testIsExit() {
        ByeCommand testByeCommand = new ByeCommand();
        assertTrue(testByeCommand.endProgram());
    }
}
