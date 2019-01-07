package lv.database;

import lv.domain.TaskList;
import lv.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    List<TaskList> findTaskLists(User user);

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long userId);

}