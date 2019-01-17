package lv.console.services.taskLists.addTaskList;

import lv.console.domain.User;

public class AddTaskListRequest {
    private User user;
    private String taskListTitle;

    public AddTaskListRequest(User user, String taskListTitle) {
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
