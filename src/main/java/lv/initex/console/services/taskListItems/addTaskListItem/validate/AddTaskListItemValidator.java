package lv.initex.console.services.taskListItems.addTaskListItem.validate;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.addTaskListItem.AddTaskListItemRequest;

import java.util.List;

public interface AddTaskListItemValidator {

    List<TaskListError> validate(AddTaskListItemRequest request);
}
