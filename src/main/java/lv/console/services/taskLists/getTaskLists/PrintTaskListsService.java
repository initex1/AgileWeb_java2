package lv.console.services.taskLists.getTaskLists;

import lv.console.database.TaskListRepository;
import lv.console.domain.TaskList;
import lv.console.services.TaskListError;
import lv.console.services.taskLists.getTaskLists.validation.PrintTaskListValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrintTaskListsService {

    @Autowired
    private TaskListRepository database;

    @Autowired
    private PrintTaskListValidator validator;

    public PrintTaskListResponse getAllTaskLists(PrintTaskListRequest request) {

        List<TaskList> taskList;
        List<TaskListError> errors = validator.validate(request);

        taskList = database.getAllTasks(request.getUser());
        PrintTaskListResponse response = new PrintTaskListResponse(taskList, errors);
        return response;
    }
}
