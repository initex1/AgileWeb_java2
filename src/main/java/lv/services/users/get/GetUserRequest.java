package lv.services.users.get;

public class GetUserRequest {
    private Long userId;

    public GetUserRequest(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
