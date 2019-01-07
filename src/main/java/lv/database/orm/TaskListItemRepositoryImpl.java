package lv.database.orm;

import lv.database.TaskListItemRepository;
import lv.domain.TaskListItem;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class TaskListItemRepositoryImpl extends ORMRepository implements TaskListItemRepository {
    @Override
    public void save(TaskListItem taskListItem) {
        session().save(taskListItem);
    }
}
