package handler;

import tasks.AbstractTask;

public class TaskHandler {
    private static final int MAXIMUM_TASKS = 5;
    private AbstractTask[] tasks;
    private int taskIndex;

    public TaskHandler() {
        this.tasks = new AbstractTask[MAXIMUM_TASKS];
        this.taskIndex = 0;
    }

    public AbstractTask getTask(int index) {
        if (index < 0 || index >= taskIndex) {
            return null;
        }
        return tasks[index];
    }

    public int getTaskIndex() {
        return taskIndex;
    }

    public void addTask(AbstractTask task) {
        if (taskIndex < MAXIMUM_TASKS) {
            tasks[taskIndex++] = task;
        }
    }

    public void removeTask(AbstractTask task) {
        for (int i = 0; i < taskIndex; i++) {
            if (tasks[i].equals(task)) {
                tasks[i] = tasks[taskIndex - 1];
                tasks[taskIndex - 1] = null;
                taskIndex--;
                break;
            }
        }
    }

    public void tickLoop(long durationInNumberOfTicks) {
        for (int i = 0; i < durationInNumberOfTicks; i++) {
            for (int j = 0; j < taskIndex; j++) {
                tasks[j].run();
            }
        }
    }
}
