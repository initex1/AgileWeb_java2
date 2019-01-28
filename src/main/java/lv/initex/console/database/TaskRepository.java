package lv.initex.console.database;

import lv.initex.console.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

  //  void addTask(Task task);

  //  boolean deleteTask(Task task);

    @Query("from Task t where t.taskTitle= :title")
    Optional<Task> findTaskByTitle(String taskName);

    List<Task> getAllTasks();


}
