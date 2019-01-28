package lv.initex.console.services.taskLists.deleteTaskList.validation.rules;

import lv.initex.console.database.UserRepository;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteTaskListNoUserRule {
    @Autowired
    private UserRepository database;


    public Optional<TaskListError> execute(Long userId) {
        if (userId != null) {
            Optional<User> findUser = database.findById(userId);
            if (!findUser.isPresent()) {
                TaskListError error = new TaskListError("UserID", "No such user!");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
