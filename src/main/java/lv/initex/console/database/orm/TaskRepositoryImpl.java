package lv.initex.console.database.orm;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TaskRepositoryImpl extends ORMRepository implements TaskRepository {



    @Override
    public void addTask(Task task) {
        session().save(task);
    }

    @Override
    public boolean deleteTask(Task task) {
        session().delete(task);
        return true;
    }

    @Override
    public Optional<Task> findTaskByTitle(String taskTitle) {
        String query = "from Task t where t.taskTitle = :title";
        Task task = (Task) session().createQuery(query)
                .setParameter("title", taskTitle)
                .uniqueResult();
        return Optional.ofNullable(task);
    }

    @Override
    public List<Task> getAllTasks() {
        String query = "from Task t";
        return session().createQuery(query).list();
    }


}