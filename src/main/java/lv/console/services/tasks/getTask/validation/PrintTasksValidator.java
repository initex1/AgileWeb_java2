package lv.console.services.tasks.getTask.validation;

import lv.console.services.TaskListError;

import java.util.List;

public interface PrintTasksValidator {
    List<TaskListError>validate();
}
