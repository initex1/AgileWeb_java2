package lv.initex.console.services.users.registration;

import lv.initex.console.services.TaskListError;

import java.util.List;

public interface UserRegistrationValidator {

    List<TaskListError> validate(UserRegistrationRequest request);

}