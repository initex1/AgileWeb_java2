package lv.initex.console.services.taskListItems.deleteTaskListItem;


import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.deleteTaskListItem.validator.DeleteTaskListItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteTaskListItemService {

    @Autowired
    private TaskListItemRepository database;

    @Autowired
    private DeleteTaskListItemValidator validator;

    public DeleteTaskListItemResponse delete(DeleteTaskListItemRequest request) {

        List<TaskListError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteTaskListItemResponse(errors);
        }
        TaskListItem taskListItem = database.findByTaskListAndTask(request.getTaskList(), request.getTask()).get();

        database.delete(taskListItem);
        return new DeleteTaskListItemResponse(taskListItem.getId());
    }
}
