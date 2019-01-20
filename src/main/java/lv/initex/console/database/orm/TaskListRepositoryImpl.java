package lv.initex.console.database.orm;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TaskListRepositoryImpl extends ORMRepository implements TaskListRepository {
    @Override
    public void save(TaskList taskList) {
        session().save(taskList);
    }

    @Override
    public void addTaskList(TaskList taskList) {
        session().save(taskList);
    }

    @Override
    public Optional<TaskList> findByUserAndTitle(User user, String listTitle) {
        String query = "from TaskList tl where tl.listTitle = :listTitle and tl.user = :user";
        TaskList taskList = (TaskList) session().createQuery(query)
                .setParameter("listTitle", listTitle)
                .setParameter("user", user)
                .uniqueResult();
        return Optional.ofNullable(taskList);
    }

    @Override
    public List<TaskList> getAllTasks(User user) {
        String query = "from TaskList tl where  tl.user = :user";
        return session().createQuery(query).setParameter("user", user).list();
    }

    @Override
    public boolean deleteTaskList(TaskList taskList) {
        session().delete(taskList);
        return true;
    }
}
