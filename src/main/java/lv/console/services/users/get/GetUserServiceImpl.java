package lv.console.services.users.get;

import lv.console.database.UserRepository;
import lv.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserServiceImpl implements GetUserService {


        @Autowired
        private UserRepository userRepository;

        @Override
        @javax.transaction.Transactional
        public GetUserResponse get(GetUserRequest request) {
            return userRepository.findById(request.getUserId())
                    .map(GetUserResponse::new)
                    .orElseGet(this::buildUserNotFoundResponse);
        }

        private GetUserResponse buildUserNotFoundResponse() {
            TaskListError error = new TaskListError("id", "not found");
            return new GetUserResponse(error);
        }

    }