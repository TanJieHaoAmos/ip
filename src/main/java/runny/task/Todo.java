package runny.task;

public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }

    @Override
    public String save() {
        return (super.isDone ? "1 " : "0 ") + "todo " + super.description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
