package lv.initex.console.database;

import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {


    Optional<TaskList> findByUserAndTitle(User user, String title);

    List<TaskList> getAllTasks(User user);




}
