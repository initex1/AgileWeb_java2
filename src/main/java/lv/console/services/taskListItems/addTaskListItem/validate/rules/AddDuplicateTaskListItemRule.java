package lv.console.services.taskListItems.addTaskListItem.validate.rules;

import lv.console.database.TaskListItemRepository;
import lv.console.domain.Task;
import lv.console.domain.TaskList;
import lv.console.domain.TaskListItem;
import lv.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddDuplicateTaskListItemRule {

    @Autowired
    private TaskListItemRepository database;

    public Optional<TaskListError> execute(TaskList taskList, Task task) {
        if (taskList != null && task != null) {
            Optional<TaskListItem> foundItem = database.findByTaskListAndTask(taskList, task);
            if (foundItem.isPresent()) {
                TaskListError error = new TaskListError("taskList task", "Duplicate taskList item exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }

}
