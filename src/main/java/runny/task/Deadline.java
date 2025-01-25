package runny.task;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected final LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        this.by = convertTime(by);
    }

    public LocalDateTime convertTime(String dateTime) throws DateTimeException {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        if (!dateTime.contains(" ")) {
            dateTime += " 2359";
        }
        return LocalDateTime.parse(dateTime, formatDate);
    }

    @Override
    public String save() {
        String dateTimeString = this.by.toString().replace("T", " ").replace(":", "");
        return (super.isDone ? "1 " : "0 ") + "deadline " + super.description + "/by" + dateTimeString;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: "
                + this.by.format(DateTimeFormatter.ofPattern("MMM dd yyyy HHmm")) + ")";
    }
}
