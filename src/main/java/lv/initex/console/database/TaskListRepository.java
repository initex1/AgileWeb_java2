package lv.initex.console.database;

import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {

    @Query("from TaskList tl where tl.user.id= :userId and tl.listTitle= :title")
    Optional<TaskList> findByUserIdAndTitle(@Param("userId")Long userId, @Param("title")String title);

    @Query("from TaskList tl where tl.user.id= :userId")
    List<TaskList> findAllByUser(@Param("userId")Long userId);




}
