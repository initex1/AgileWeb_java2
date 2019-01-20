package lv.initex.console.services.taskListItems.getTaskListItems;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.getTaskListItems.validator.GetTaskListItemsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTaskListItemsService {

    @Autowired
    private TaskListItemRepository database;

    @Autowired
    private GetTaskListItemsValidator validator;

    public GetTaskListItemsResponse getAllTaskListItems(GetTaskListItemsRequest request) {
        List<TaskListItem> taskList;
        List<TaskListError> errors = validator.validate(request);

        taskList = database.getAllTaskListItems(request.getTaskList());
        GetTaskListItemsResponse response = new GetTaskListItemsResponse(taskList, errors);
        return response;
    }
}
