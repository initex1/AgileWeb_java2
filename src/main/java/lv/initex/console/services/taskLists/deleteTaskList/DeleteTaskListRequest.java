package lv.initex.console.services.taskLists.deleteTaskList;

import lv.initex.console.domain.User;

public class DeleteTaskListRequest {

    private User user;

    private String taskListTitle;

    public DeleteTaskListRequest(User user, String taskListTitle) {
        this.user = user;
        this.taskListTitle = taskListTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaskListTitle() {
        return taskListTitle;
    }

    public void setTaskListTitle(String taskListTitle) {
        this.taskListTitle = taskListTitle;
    }
}
