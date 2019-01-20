package lv.initex.console.services.taskListItems.getTaskListItems.validator;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.getTaskListItems.GetTaskListItemsRequest;

import java.util.List;

public interface GetTaskListItemsValidator {

    List<TaskListError> validate(GetTaskListItemsRequest request);
}
