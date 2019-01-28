package lv.initex.console.services.taskListItems.getTaskListItems.validator.rules;


import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GetTaskListItemEmptyRule {

    @Autowired
    private TaskListItemRepository database;

    public Optional<TaskListError> execute(TaskList taskList ) {
        List<TaskListItem> taskListItems = database.getAllByTaskList(taskList);
        if (taskListItems.isEmpty()) {
            TaskListError error = new TaskListError("List", "TaskListItem list is empty!");
            return Optional.of(error);
        }
        return Optional.empty();

    }
}
