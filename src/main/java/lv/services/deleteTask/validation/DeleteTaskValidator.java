package lv.services.deleteTask.validation;

import lv.services.Error;
import lv.services.deleteTask.DeleteTaskRequest;

import java.util.List;

public interface DeleteTaskValidator {
     List<Error> validate(DeleteTaskRequest deleteTaskRequest);
}
