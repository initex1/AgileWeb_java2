package lv.services.addTask;



public class AddTaskRequest {
    private String taskTitle;


    public AddTaskRequest(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }


}
