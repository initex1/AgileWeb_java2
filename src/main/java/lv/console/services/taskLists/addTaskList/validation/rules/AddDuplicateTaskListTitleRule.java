package lv.console.services.taskLists.addTaskList.validation.rules;


import lv.console.database.TaskListRepository;
import lv.console.domain.TaskList;
import lv.console.domain.User;
import lv.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddDuplicateTaskListTitleRule {

    @Autowired
    private TaskListRepository database;

    public Optional<TaskListError> execute(User user, String taskListTitle) {
        if (taskListTitle != null) {
            Optional<TaskList> taskList = database.findByUserAndTitle(user, taskListTitle);
            if (taskList.isPresent()) {
                TaskListError error = new TaskListError("taskList title", "Duplicate taskList exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}

