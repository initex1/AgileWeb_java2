package lv.console.services.tasks.getTask;

import lv.console.database.TaskRepository;
import lv.console.domain.Task;
import lv.console.services.TaskListError;
import lv.console.services.tasks.getTask.validation.PrintTaskListValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrintTaskListService {

    @Autowired
    TaskRepository database;


    @Autowired
    private PrintTaskListValidator validator;

    public PrintTaskListResponse getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        List<TaskListError> errors = validator.validate();

        if (!errors.isEmpty()) {
            return new PrintTaskListResponse(tasks, errors);
        }
        tasks = database.getAllTasks();
        PrintTaskListResponse response = new PrintTaskListResponse(tasks, errors);
        return response;
    }
}
