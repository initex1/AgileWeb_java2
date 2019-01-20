package lv.initex.console.services.tasks.deleteTask.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.deleteTask.DeleteTaskRequest;

import java.util.List;

public interface DeleteTaskValidator {
     List<TaskListError> validate(DeleteTaskRequest deleteTaskRequest);
}
