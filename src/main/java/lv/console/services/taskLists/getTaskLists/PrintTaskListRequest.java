package lv.console.services.taskLists.getTaskLists;

import lv.console.domain.User;

public class PrintTaskListRequest {

    private User user;

    public PrintTaskListRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
