package lv.initex.console.services.tasks.getTask.validation;

import lv.initex.console.services.TaskListError;

import java.util.List;

public interface GetTasksValidator {
    List<TaskListError>validate();
}
