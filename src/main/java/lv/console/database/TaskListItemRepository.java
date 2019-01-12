package lv.console.database;

import lv.console.domain.TaskListItem;

public interface TaskListItemRepository {
    void save(TaskListItem taskListItem);
}
