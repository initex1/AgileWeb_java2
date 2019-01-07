package lv.services.tasks.getTask.validation;

import lv.services.TaskListError;

import java.util.List;

public interface PrintTaskListValidator {
    List<TaskListError>validate();
}
