package lv.initex.console.services.taskListItems.getTaskListItems;

import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;

public class GetTaskListItemsRequest {

    private User user;

    private TaskList taskList;

    public GetTaskListItemsRequest(User user, TaskList taskList) {
        this.user = user;
        this.taskList = taskList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}
