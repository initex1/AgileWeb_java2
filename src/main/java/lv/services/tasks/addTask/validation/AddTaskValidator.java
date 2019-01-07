package lv.services.tasks.addTask.validation;

import lv.services.TaskListError;
import lv.services.tasks.addTask.AddTaskRequest;

import java.util.List;

public interface AddTaskValidator {
    List<TaskListError> validate(AddTaskRequest request);
}
