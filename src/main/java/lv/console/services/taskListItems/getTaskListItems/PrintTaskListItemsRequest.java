package lv.console.services.taskListItems.getTaskListItems;

import lv.console.domain.TaskList;
import lv.console.domain.User;

public class PrintTaskListItemsRequest {

    private User user;

    private TaskList taskList;

    public PrintTaskListItemsRequest(User user, TaskList taskList) {
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
