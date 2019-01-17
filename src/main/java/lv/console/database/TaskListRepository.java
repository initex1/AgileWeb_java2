package lv.console.database;

import lv.console.domain.TaskList;
import lv.console.domain.User;

import java.util.List;
import java.util.Optional;

public interface TaskListRepository {
    void save(TaskList taskList);

    void addTaskList(TaskList taskList);

    Optional<TaskList> findByUserAndTitle(User user, String title);

    List<TaskList> getAllTasks(User user);

    boolean deleteTaskList(TaskList taskList);


}
