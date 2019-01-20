package lv.initex.console.services.tasks.addTask.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.addTask.AddTaskRequest;

import java.util.List;

public interface AddTaskValidator {
    List<TaskListError> validate(AddTaskRequest request);
}
