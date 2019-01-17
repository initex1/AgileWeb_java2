package lv.console.services.taskListItems.deleteTaskListItem.validator;

import lv.console.services.TaskListError;
import lv.console.services.taskListItems.deleteTaskListItem.DeleteTaskListItemRequest;

import java.util.List;

public interface DeleteTaskListItemValidator {
    List<TaskListError> validate(DeleteTaskListItemRequest request);
}
