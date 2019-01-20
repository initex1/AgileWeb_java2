package lv.initex.console.services.taskLists.getTaskLists;

import lv.initex.console.domain.User;

public class GetTaskListRequest {

    private User user;

    public GetTaskListRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
