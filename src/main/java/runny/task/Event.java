package runny.task;

public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String save() {
        return (super.isDone ? "1 " : "0 ") + "event " + super.description + "/from" + this.from + "/to" + this.to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + "to: " + this.to + ")";
    }
}
