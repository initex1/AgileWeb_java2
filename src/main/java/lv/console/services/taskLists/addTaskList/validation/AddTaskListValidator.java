package lv.console.services.taskLists.addTaskList.validation;

import lv.console.services.TaskListError;
import lv.console.services.taskLists.addTaskList.AddTaskListRequest;

import java.util.List;

public interface AddTaskListValidator {
    List<TaskListError> validate(AddTaskListRequest request);
}
