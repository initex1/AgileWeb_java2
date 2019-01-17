package lv.console.services.taskLists.deleteTaskList.validation;

import lv.console.services.TaskListError;
import lv.console.services.taskLists.deleteTaskList.DeleteTaskListRequest;

import java.util.List;

public interface DeleteTaskListValidator {

    List<TaskListError> validate(DeleteTaskListRequest request);
}
