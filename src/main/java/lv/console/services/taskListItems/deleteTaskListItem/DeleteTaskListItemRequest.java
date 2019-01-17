package lv.console.services.taskListItems.deleteTaskListItem;

import lv.console.domain.Task;
import lv.console.domain.TaskList;

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
