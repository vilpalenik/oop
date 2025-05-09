package tasks;

public abstract class AbstractTask {
    private String id;
    protected String message;
    protected long runAtTick;

    public AbstractTask(String message, long runAtTick) {
        this.id = TaskIdGenerator.generateTaskId(this);
        this.message = message;
        this.runAtTick = runAtTick;
    }

    public String getId() {
        return this.id;
    }

    public abstract void run();

    public abstract boolean equals(Object obj);
}