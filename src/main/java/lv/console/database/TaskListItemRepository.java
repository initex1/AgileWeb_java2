package lv.console.database;

import lv.console.domain.Task;
import lv.console.domain.TaskList;
import lv.console.domain.TaskListItem;

import java.util.List;
import java.util.Optional;

public interface TaskListItemRepository {
    void save(TaskListItem taskListItem);

    Optional<TaskListItem> findByTaskListAndTask(TaskList taskList, Task task);

    boolean deleteTaskListItem(TaskListItem taskListItem);

    List<TaskListItem> getAllTaskListitems(TaskList taskList);

}
