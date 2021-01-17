/**
 * An abstract class Task in added by the user.
 */
public abstract class Task {
    /**
     * Description of the task.
     */
    protected String description;

    /**
     * Indicates if the task is completed.
     */
    protected boolean isDone;

    /**
     * Creates a new task with the provided description.
     *
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Mark the task as completed
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns the status icon for the task.
     * If done, returns a tick (unicode character), else it will return space
     *
     * @return
     */
    private String getStatusIcon() {
        return (isDone ? "\u2713" : " "); //return tick or X symbols
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
