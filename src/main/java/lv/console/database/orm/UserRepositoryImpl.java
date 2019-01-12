package lv.console.database.orm;

import lv.console.database.UserRepository;
import lv.console.domain.TaskList;
import lv.console.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class UserRepositoryImpl extends ORMRepository implements UserRepository {
    @Override
    public void save(User user) {
        session().save(user);
    }

    @Override
    public List<TaskList> findTaskLists(User user) {
        String query = "from TaskList tl where tl.user = :user";
        return session().createQuery(query)
                .setParameter("user", user)
                .list();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        String query = "from User u where u.login = :login";
        User user = (User) session().createQuery(query)
                .setParameter("login", login)
                .uniqueResult();
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findById(Long userId) {
        String query = "from User u where u.id = :id";
        User user = (User) session().createQuery(query)
                .setParameter("id", userId)
                .uniqueResult();
        return Optional.ofNullable(user);
    }
}
