package lv.initex.console.services.taskListItems.deleteTaskListItem;

import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;

public class DeleteTaskListItemRequest {

    private TaskList taskList;
    private Task task;

    public DeleteTaskListItemRequest(TaskList taskList, Task task) {
        this.taskList = taskList;
        this.task = task;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
