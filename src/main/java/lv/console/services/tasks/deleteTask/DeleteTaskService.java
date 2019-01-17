package lv.console.services.tasks.deleteTask;

import lv.console.database.TaskRepository;
import lv.console.domain.Task;
import lv.console.services.TaskListError;
import lv.console.services.tasks.deleteTask.validation.DeleteTaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteTaskService {

    @Autowired
    private TaskRepository database;

    @Autowired
    private DeleteTaskValidator validator;


    public DeleteTaskResponse delete(DeleteTaskRequest request) {

        List<TaskListError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteTaskResponse(errors);
        }
        Task task = database.findTaskByTitle(request.getTaskTitle()).get();
        database.deleteTask(task);
        return new DeleteTaskResponse(task.getId());
    }
}
