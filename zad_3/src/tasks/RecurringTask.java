package tasks;

public class RecurringTask extends AbstractTask {
    private long delayBetweenRuns;
    private int numberOfRuns;

    public RecurringTask(String message, long runAtTick, long delayBetweenRuns, int numberOfRuns) {
        super(message, runAtTick);
        this.delayBetweenRuns = delayBetweenRuns;
        this.numberOfRuns = numberOfRuns;
    }

    public int getNumberOfRuns() {
        return numberOfRuns;
    }

    @Override
    public void run() {
        System.out.println("Running RecurringTask: " + message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RecurringTask that = (RecurringTask) obj;
        return id.equals(that.id);
    }
}
