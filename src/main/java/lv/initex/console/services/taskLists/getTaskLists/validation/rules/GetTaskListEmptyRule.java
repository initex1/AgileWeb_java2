package lv.initex.console.services.taskLists.getTaskLists.validation.rules;


import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GetTaskListEmptyRule {

    @Autowired
    private TaskListRepository database;

    public Optional<TaskListError> execute(Long userId) {
        List<TaskList> taskList = database.findAllByUser(userId);
        if (taskList.isEmpty()) {
            TaskListError error = new TaskListError("List", "User don't have any taskList");
            return Optional.of(error);
        }
        return Optional.empty();
    }
}
