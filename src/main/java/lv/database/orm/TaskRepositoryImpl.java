package lv.database.orm;

import lv.database.TaskRepository;
import lv.domain.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TaskRepositoryImpl implements TaskRepository {


    @Autowired
    private SessionFactory session;

    @Override
    public void addTask(Task task) {
        session.getCurrentSession().save(task);
    }

    @Override
    public boolean deleteTask(Task task) {
        session.getCurrentSession().delete(task);
        return true;
    }

    @Override
    public Optional<Task> findTaskByTitle(String taskTitle) {
        String query = "from Task t where t.taskTitle = :title";
        Task task = (Task) session.getCurrentSession().createQuery(query)
                .setParameter("title", taskTitle)
                .uniqueResult();
        return Optional.ofNullable(task);
    }

    @Override
    public List<Task> getAllTasks() {
        String query = "from Task t";
        return session.getCurrentSession().createQuery(query).list();
    }
}