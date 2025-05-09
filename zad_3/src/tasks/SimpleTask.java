package tasks;

public class SimpleTask extends AbstractTask {
    public SimpleTask(String message, long runAtTick) {
        super(message, runAtTick);
    }

    @Override
    public void run() {
        System.out.println("Running SimpleTask: " + message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SimpleTask that = (SimpleTask) obj;
        return id.equals(that.id);
    }
}
