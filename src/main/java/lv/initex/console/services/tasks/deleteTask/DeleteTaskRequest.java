package lv.initex.console.services.tasks.deleteTask;

public class DeleteTaskRequest {
    private String taskTitle;

    public DeleteTaskRequest(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
}
