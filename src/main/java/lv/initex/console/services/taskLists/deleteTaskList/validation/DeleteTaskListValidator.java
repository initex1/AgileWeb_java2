package lv.initex.console.services.taskLists.deleteTaskList.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.deleteTaskList.DeleteTaskListRequest;

import java.util.List;

public interface DeleteTaskListValidator {

    List<TaskListError> validate(DeleteTaskListRequest request);
}
