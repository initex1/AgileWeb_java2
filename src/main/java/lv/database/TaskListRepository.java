package lv.database;

import lv.domain.TaskList;
import lv.domain.User;

import java.util.Optional;

public interface TaskListRepository {
    void save(TaskList taskList);

    Optional<TaskList> findByUserAndTitle(User user, String title);

}
