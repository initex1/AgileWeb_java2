package lv.console.services.taskListItems.getTaskListItems.validator.rules;


import lv.console.database.TaskListItemRepository;
import lv.console.domain.TaskList;
import lv.console.domain.TaskListItem;
import lv.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PrintTaskListItemEmptyRule {

    @Autowired
    private TaskListItemRepository database;

    public Optional<TaskListError> execute(TaskList taskList ) {
        List<TaskListItem> taskListItems = database.getAllTaskListitems(taskList);
        if (taskListItems.isEmpty()) {
            TaskListError error = new TaskListError("List", "TaskList list is empty!");
            return Optional.of(error);
        }
        return Optional.empty();

    }
}
