package lv.console.services.taskListItems.addTaskListItem.validate;

import lv.console.services.TaskListError;
import lv.console.services.taskListItems.addTaskListItem.AddTaskListItemRequest;

import java.util.List;

public interface AddTaskListItemValidator {

    List<TaskListError> validate(AddTaskListItemRequest request);
}
