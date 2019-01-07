package lv.database;

import lv.domain.TaskListItem;

public interface TaskListItemRepository {
    void save(TaskListItem taskListItem);
}
