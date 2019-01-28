package lv.initex.console.services.taskLists.getTaskLists;

public class GetTaskListRequest {

    private Long userId;

    public GetTaskListRequest(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
