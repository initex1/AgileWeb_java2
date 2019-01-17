package lv.console.services.taskListItems.getTaskListItems;

import lv.console.domain.TaskListItem;
import lv.console.services.TaskListError;

import java.util.List;

public class PrintTaskListItemsResponse {

    private List<TaskListItem> taskListItems;
    private List<TaskListError> errors;

    public PrintTaskListItemsResponse(List<TaskListItem> taskListItems, List<TaskListError> errors) {
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
