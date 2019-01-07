package lv.services.tasks.deleteTask.validation;

import lv.services.TaskListError;
import lv.services.tasks.deleteTask.DeleteTaskRequest;

import java.util.List;

public interface DeleteTaskValidator {
     List<TaskListError> validate(DeleteTaskRequest deleteTaskRequest);
}
