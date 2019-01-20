package lv.initex.console.services.taskListItems.deleteTaskListItem.validator;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.deleteTaskListItem.DeleteTaskListItemRequest;

import java.util.List;

public interface DeleteTaskListItemValidator {
    List<TaskListError> validate(DeleteTaskListItemRequest request);
}
