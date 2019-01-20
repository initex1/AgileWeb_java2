package lv.initex.console.services.taskListItems.deleteTaskListItem.validator.rules;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteTaskListItemNotFoundRule {

    @Autowired
    private TaskListItemRepository database;

    public Optional<TaskListError> execute(TaskList taskList, Task task) {
        if (taskList != null && task != null) {
            Optional<TaskListItem> foundItem = database.findByTaskListAndTask(taskList, task);
            if (!foundItem.isPresent()) {
                TaskListError error = new TaskListError("TaskListItem", "No such taskListItem!");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}