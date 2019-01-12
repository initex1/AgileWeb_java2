package lv.console.services.users.registration;

import lv.console.services.TaskListError;

import java.util.List;

public interface UserRegistrationValidator {

    List<TaskListError> validate(UserRegistrationRequest request);

}