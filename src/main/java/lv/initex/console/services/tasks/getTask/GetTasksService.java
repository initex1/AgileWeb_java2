package lv.initex.console.services.tasks.getTask;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.getTask.validation.GetTasksValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetTasksService {

    @Autowired
    TaskRepository database;


    @Autowired
    private GetTasksValidator validator;

    public GetTasksResponse getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        List<TaskListError> errors = validator.validate();


        if (!errors.isEmpty()) {
            return new GetTasksResponse(tasks, errors);
        }
        tasks = database.getAllTasks();
        GetTasksResponse response = new GetTasksResponse(tasks, errors);
        return response;
    }
}
