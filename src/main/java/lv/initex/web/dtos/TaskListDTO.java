package lv.initex.web.dtos;

public class TaskListDTO {
    private Long userId;
    private String taskListTitle;

    public TaskListDTO(Long userId) {
        this.userId = userId;
    }

    public TaskListDTO(Long userId, String taskListTitle) {
        this.userId = userId;
        this.taskListTitle = taskListTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTaskListTitle() {
        return taskListTitle;
    }

    public void setTaskListTitle(String taskListTitle) {
        this.taskListTitle = taskListTitle;
    }
}
