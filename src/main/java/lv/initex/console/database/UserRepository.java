package lv.initex.console.database;

import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  //  void save(User user);

  //  List<TaskList> findTaskLists(User user);

    @Query("from User u where u.login= :login")
    Optional<User> findByLogin(String login);

    Optional<User> findById(Long userId);

}