package lv.services.users.registration;

import lv.services.TaskListError;

import java.util.List;

public class UserRegistrationResponse {

    private Long userId;
    private List<TaskListError> errors;

    public UserRegistrationResponse(Long userId) {
        this.userId = userId;
    }

    public UserRegistrationResponse(List<TaskListError> errors) {
        this.errors = errors;
    }

    public Long getUserId() {
        return userId;
    }

    public List<TaskListError> getErrors() {
        return errors;
    }

    public boolean isSuccess() {
        return userId != null
                && (errors == null || errors.isEmpty());
    }

}