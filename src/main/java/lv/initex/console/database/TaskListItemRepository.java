package lv.initex.console.database;

import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskListItemRepository extends JpaRepository<TaskListItem,Long> {


    Optional<TaskListItem> findByTaskListAndTask(TaskList taskList, Task task);



    List<TaskListItem> getAllByTaskList(TaskList taskList);

}
