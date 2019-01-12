package lv.console.services.users.get;

import org.springframework.transaction.annotation.Transactional;

public class GetUserServiceImpl implements GetUserService {


    @Override
    @Transactional
    public GetUserResponse get(GetUserRequest request) {
        return null;
    }
}
