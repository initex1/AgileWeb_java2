package lv.services.deleteTask;

import lv.database.TaskRepository;
import lv.domain.Task;
import lv.services.Error;
import lv.services.deleteTask.validation.DeleteTaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DeleteTaskService {

    @Autowired
    TaskRepository database;

    @Autowired
    private DeleteTaskValidator validator;


    public DeleteTaskResponse delete(DeleteTaskRequest request) {

        List<Error> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteTaskResponse(errors);
        }
        Task task = database.findTaskByTitle(request.getTaskTitle()).get();
        database.deleteTask(task);
        return new DeleteTaskResponse(task.getId());
    }

    public List<Task> getAllTasks() {
        return database.getAllTasks();
    }
}
