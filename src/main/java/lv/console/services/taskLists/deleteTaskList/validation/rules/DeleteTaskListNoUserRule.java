package lv.console.services.taskLists.deleteTaskList.validation.rules;

import lv.console.database.UserRepository;
import lv.console.domain.User;
import lv.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteTaskListNoUserRule {
    @Autowired
    private UserRepository database;


    public Optional<TaskListError> execute(User user) {
        if (user != null) {
            Optional<User> findUser = database.findById(user.getId());
            if (!findUser.isPresent()) {
                TaskListError error = new TaskListError("UserID", "No such user!");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
