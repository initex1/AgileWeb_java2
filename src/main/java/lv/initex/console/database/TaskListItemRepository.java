package lv.initex.console.database;

import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;

import java.util.List;
import java.util.Optional;

public interface TaskListItemRepository {
    void save(TaskListItem taskListItem);

    Optional<TaskListItem> findByTaskListAndTask(TaskList taskList, Task task);

    boolean deleteTaskListItem(TaskListItem taskListItem);

    List<TaskListItem> getAllTaskListItems(TaskList taskList);

}
