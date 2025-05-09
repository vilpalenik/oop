package tasks;

public abstract class AbstractTask {
    protected String id;
    protected String message;
    protected long runAtTick;

    public AbstractTask(String message, long runAtTick) {
        this.id = TaskIdGenerator.generateTaskId(this);
        this.message = message;
        this.runAtTick = runAtTick;
    }

    public String getId() {
        return id;
    }

    public abstract void run();
}