package lv.console.services.taskListItems.addTaskListItem;

import lv.console.database.TaskListItemRepository;
import lv.console.domain.TaskListItem;
import lv.console.domain.TaskStatusEnum;
import lv.console.services.TaskListError;
import lv.console.services.taskListItems.addTaskListItem.validate.AddTaskListItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddTaskListItemService {

    @Autowired
    private TaskListItemRepository database;

    @Autowired
    private AddTaskListItemValidator validator;

    public AddTaskListItemResponse add(AddTaskListItemRequest request){
        List<TaskListError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddTaskListItemResponse(errors);
        }
        TaskListItem item=new TaskListItem();
        item.setTaskList(request.getTaskList());
        item.setTask(request.getTask());
        item.setStatus(TaskStatusEnum.ACTIVE);
        database.save(item);
        return new AddTaskListItemResponse(item.getId());
    }

}
