package lv.console.database;

import lv.console.domain.TaskList;
import lv.console.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    List<TaskList> findTaskLists(User user);

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long userId);

}