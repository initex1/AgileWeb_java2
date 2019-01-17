package lv.console.services.taskLists.getTaskLists.validation;

import lv.console.services.TaskListError;
import lv.console.services.taskLists.getTaskLists.PrintTaskListRequest;

import java.util.List;

public interface PrintTaskListValidator {
    List<TaskListError> validate(PrintTaskListRequest request);
}
