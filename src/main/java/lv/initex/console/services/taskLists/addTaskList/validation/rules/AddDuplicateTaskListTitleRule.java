package lv.initex.console.services.taskLists.addTaskList.validation.rules;


import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddDuplicateTaskListTitleRule {

    @Autowired
    private TaskListRepository database;

    public Optional<TaskListError> execute(Long userId, String taskListTitle) {
        if (taskListTitle != null) {
            Optional<TaskList> taskList = database.findByUserIdAndTitle(userId, taskListTitle);
            if (taskList.isPresent()) {
                TaskListError error = new TaskListError("taskList title", "Duplicate taskList exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}

