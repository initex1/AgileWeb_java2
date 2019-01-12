package lv.console.services.tasks.addTask;

import lv.console.database.TaskRepository;
import lv.console.domain.Task;
import lv.console.services.TaskListError;
import lv.console.services.tasks.addTask.validation.AddTaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddTaskService {

    @Autowired
    private TaskRepository database;

    @Autowired
    private AddTaskValidator validator;

    public AddTaskResponse add(AddTaskRequest request) {
        List<TaskListError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AddTaskResponse(errors);
        }
        Task task = new Task();
        task.setTaskTitle(request.getTaskTitle());
        database.addTask(task);

        return new AddTaskResponse(task.getId());
    }
}
