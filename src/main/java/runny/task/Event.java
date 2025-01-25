package runny.task;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = convertTimeFrom(from);
        this.to = convertTimeTo(to);
    }

    public LocalDateTime convertTimeFrom(String dateTime) throws DateTimeException {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        if (!dateTime.contains(" ")) {
            dateTime += " 0000";
        }
        return LocalDateTime.parse(dateTime, formatDate);
    }
    public LocalDateTime convertTimeTo(String time) throws DateTimeException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        if (!time.contains(" ")) {
            time += " 2359";
        }
        return LocalDateTime.parse(time, formatter);
    }


    @Override
    public String save() {
        String saveFrom = this.from.toString().replace("T", " ").replace(":", "");
        String saveTo = this.to.toString().replace("T", " ").replace(":", "");
        return (super.isDone ? "1 " : "0 ") + "event " + super.description + "/from" + saveFrom + "/to" + saveTo;
    }

    @Override
    public String toString() {

        return "[E]" + super.toString() + " (from: " + this.from.format(DateTimeFormatter.ofPattern("MMM dd yyyy HHmm")) + " to: " + this.to.format(DateTimeFormatter.ofPattern("MMM dd yyyy HHmm")) + ")";
    }
}
