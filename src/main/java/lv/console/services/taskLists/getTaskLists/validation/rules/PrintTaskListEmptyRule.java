package lv.console.services.taskLists.getTaskLists.validation.rules;


import lv.console.database.TaskListRepository;
import lv.console.domain.TaskList;
import lv.console.domain.User;
import lv.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PrintTaskListEmptyRule {

    @Autowired
    private TaskListRepository database;

    public Optional<TaskListError> execute(User user) {
        List<TaskList> taskList = database.getAllTasks(user);
        if (taskList.isEmpty()) {
            TaskListError error = new TaskListError("List", "User don't have any taskList");
            return Optional.of(error);
        }
        return Optional.empty();
    }
}
