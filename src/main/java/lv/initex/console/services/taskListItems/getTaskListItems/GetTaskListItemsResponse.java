package lv.initex.console.services.taskListItems.getTaskListItems;

import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;

import java.util.List;

public class GetTaskListItemsResponse {

    private List<TaskListItem> taskListItems;
    private List<TaskListError> errors;

    public GetTaskListItemsResponse(List<TaskListItem> taskListItems, List<TaskListError> errors) {
        this.taskListItems = taskListItems;
        this.errors = errors;
    }

    public List<TaskListItem> getTaskListItems() {
        return taskListItems;
    }

    public void setTaskListItems(List<TaskListItem> taskListItems) {
        this.taskListItems = taskListItems;
    }

    public List<TaskListError> getErrors() {
        return errors;
    }

    public void setErrors(List<TaskListError> errors) {
        this.errors = errors;
    }
}
