package lv.services.addTask.validation;

import lv.services.Error;
import lv.services.addTask.AddTaskRequest;

import java.util.List;

public interface AddTaskValidator {
    List<Error> validate(AddTaskRequest request);
}
