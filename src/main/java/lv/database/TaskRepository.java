package lv.database;

import lv.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    void addTask(Task task);
    boolean deleteTask(Task task);
    Optional<Task> findTaskByTitle(String taskName);
    List<Task> getAllTasks();
}
