package runny.parser;

import runny.RunnyException;
import runny.commands.*;

import java.time.DateTimeException;


public class Parser {
    public static Command parse(String fullCommand) throws RunnyException {

        String[] splitCommand = fullCommand.split(" ", 2);
        String command = splitCommand[0];
        String info = "";

        for (int i = 1; i < splitCommand.length; i++) {
            if (splitCommand.length == 2) {
                info = splitCommand[1];
            }
        }

        switch (command) {
        case "bye":
            return new ByeCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(info);
        case "unmark":
            return new UnmarkCommand(info);
        case "todo":
            return new TodoCommand(info);
        case "event":
            return new EventCommand(info);
        case "deadline":
            return new DeadlineCommand(info);
        case "delete":
            return new DeleteCommand(info);
        default:
            throw new RunnyException("OOPS!!! I'm sorry, but I do not understand that command :-(\n");
        }
    }
}
