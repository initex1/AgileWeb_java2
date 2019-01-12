package lv.console.services.tasks.addTask.validation;

import lv.console.services.TaskListError;
import lv.console.services.tasks.addTask.AddTaskRequest;

import java.util.List;

public interface AddTaskValidator {
    List<TaskListError> validate(AddTaskRequest request);
}
