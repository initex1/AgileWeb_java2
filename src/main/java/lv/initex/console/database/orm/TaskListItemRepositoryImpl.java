package lv.initex.console.database.orm;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Component
@Transactional
public class TaskListItemRepositoryImpl extends ORMRepository implements TaskListItemRepository {
    @Override
    public void save(TaskListItem taskListItem) {
        session().save(taskListItem);
    }

    @Override
    public Optional<TaskListItem> findByTaskListAndTask(TaskList taskList, Task task) {
        String query = "from TaskListItem tli where tli.taskList = :taskList and tl.task = :task";
        TaskListItem taskListItemList = (TaskListItem) session().createQuery(query)
                .setParameter("taskList", taskList)
                .setParameter("task", task)
                .uniqueResult();
        return Optional.ofNullable(taskListItemList);
    }

    @Override
    public boolean deleteTaskListItem(TaskListItem taskListItem) {
        session().delete(taskListItem);
        return true;
    }

    @Override
    public List<TaskListItem> getAllTaskListItems(TaskList taskList) {
        String query = "from TaskListItem tli where  tli.taskList = :taskList";
        return session().createQuery(query).setParameter("taskList", taskList).list();
    }
}
