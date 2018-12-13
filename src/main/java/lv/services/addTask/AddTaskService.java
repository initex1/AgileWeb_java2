package lv.services.addTask;

import lv.database.TaskRepository;
import lv.domain.Task;
import lv.services.Error;
import lv.services.addTask.validation.AddTaskValidator;
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
        List<Error> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AddTaskResponse(errors);
        }
        Task task = new Task();
        task.setTaskTitle(request.getTaskTitle());
        database.addTask(task);

        return new AddTaskResponse(task.getId());
    }
}
