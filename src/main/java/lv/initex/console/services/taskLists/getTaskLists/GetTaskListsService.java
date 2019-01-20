package lv.initex.console.services.taskLists.getTaskLists;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.getTaskLists.validation.GetTaskListValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTaskListsService {

    @Autowired
    private TaskListRepository database;

    @Autowired
    private GetTaskListValidator validator;

    public GetTaskListResponse getAllTaskLists(GetTaskListRequest request) {

        List<TaskList> taskList;
        List<TaskListError> errors = validator.validate(request);

        taskList = database.getAllTasks(request.getUser());
        GetTaskListResponse response = new GetTaskListResponse(taskList, errors);
        return response;
    }
}
