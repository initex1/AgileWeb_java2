package lv.services.users.registration;

import lv.services.TaskListError;

import java.util.List;

public interface UserRegistrationValidator {

    List<TaskListError> validate(UserRegistrationRequest request);

}