package lv.console.services.taskListItems.deleteTaskListItem;

import lv.console.services.TaskListError;

import java.util.List;

public class DeleteTaskListItemResponse {
    private Long taskListItemId;
    private List<TaskListError> errors;

    public DeleteTaskListItemResponse(Long taskListItemId) {
        this.taskListItemId = taskListItemId;
    }

    public DeleteTaskListItemResponse(List<TaskListError> errors) {
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
