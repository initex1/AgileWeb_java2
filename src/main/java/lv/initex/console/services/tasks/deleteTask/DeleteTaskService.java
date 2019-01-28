package lv.initex.console.services.tasks.deleteTask;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.deleteTask.validation.DeleteTaskValidator;
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
        database.delete(task);
        return new DeleteTaskResponse(task.getId());
    }
}
