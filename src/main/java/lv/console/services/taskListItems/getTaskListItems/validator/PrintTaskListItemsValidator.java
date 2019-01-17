package lv.console.services.taskListItems.getTaskListItems.validator;

import lv.console.services.TaskListError;
import lv.console.services.taskListItems.getTaskListItems.PrintTaskListItemsRequest;

import java.util.List;

public interface PrintTaskListItemsValidator {

    List<TaskListError> validate(PrintTaskListItemsRequest request);
}
