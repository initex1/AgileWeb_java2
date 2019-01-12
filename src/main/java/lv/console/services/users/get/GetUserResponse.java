package lv.console.services.users.get;

import lv.console.domain.User;
import lv.console.services.TaskListError;

public class GetUserResponse {

    private User user;

    private TaskListError error;

    public GetUserResponse(User user) {
        this.user = user;
    }

    public GetUserResponse(TaskListError error) {
        this.error = error;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskListError getError() {
        return error;
    }

    public void setError(TaskListError error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return user != null && (error == null) ;
    }
}
