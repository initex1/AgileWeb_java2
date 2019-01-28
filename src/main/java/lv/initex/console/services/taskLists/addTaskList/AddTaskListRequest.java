package lv.initex.console.services.taskLists.addTaskList;

public class AddTaskListRequest {
    private Long userId;
    private String taskListTitle;

    public AddTaskListRequest(Long userid, String taskListTitle) {
        this.userId = userid;
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
