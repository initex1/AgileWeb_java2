package lv.console.services.tasks.getTask.validation.rules;

import lv.console.database.TaskRepository;
import lv.console.domain.Task;
import lv.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PrintTaskListEmptyRule {

    @Autowired
    private TaskRepository database;

    public PrintTaskListEmptyRule(TaskRepository database) {
        this.database = database;
    }

    public Optional<TaskListError> execute(){
        List<Task> tasks=database.getAllTasks();
        if(tasks.isEmpty()){
            TaskListError error=new TaskListError("User", "User don't have any task");
            return Optional.of(error);
        }
        return Optional.empty();
    }
}
