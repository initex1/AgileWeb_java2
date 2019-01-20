package lv.initex.console.services.taskLists.getTaskLists.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.getTaskLists.GetTaskListRequest;

import java.util.List;

public interface GetTaskListValidator {
    List<TaskListError> validate(GetTaskListRequest request);
}
