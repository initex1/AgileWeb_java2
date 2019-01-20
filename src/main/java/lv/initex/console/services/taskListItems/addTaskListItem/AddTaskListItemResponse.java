package lv.initex.console.services.taskListItems.addTaskListItem;

import lv.initex.console.services.TaskListError;

import java.util.List;

public class AddTaskListItemResponse {

    private Long taskListItemId;
    private List<TaskListError> errors;

    public AddTaskListItemResponse(Long taskListItemId) {
        this.taskListItemId = taskListItemId;
    }

    public AddTaskListItemResponse(List<TaskListError> errors) {
        this.errors = errors;
    }

    public Long getTaskListItemId() {
        return taskListItemId;
    }

    public void setTaskListItemId(Long taskListItemId) {
        this.taskListItemId = taskListItemId;
    }

    public List<TaskListError> getErrors() {
        return errors;
    }

    public void setErrors(List<TaskListError> errors) {
        this.errors = errors;
    }
}
