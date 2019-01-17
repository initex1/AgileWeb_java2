package lv.console.services.tasks.getTask;

import lv.console.database.TaskRepository;
import lv.console.domain.Task;
import lv.console.services.TaskListError;
import lv.console.services.tasks.getTask.validation.PrintTasksValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrintTasksService {

    @Autowired
    TaskRepository database;


    @Autowired
    private PrintTasksValidator validator;

    public PrintTasksResponse getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        List<TaskListError> errors = validator.validate();

        if (!errors.isEmpty()) {
            return new PrintTasksResponse(tasks, errors);
        }
        tasks = database.getAllTasks();
        PrintTasksResponse response = new PrintTasksResponse(tasks, errors);
        return response;
    }
}
