package lv.services.getTask.validation.rules;

import lv.database.TaskRepository;
import lv.domain.Task;
import lv.services.Error;
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

    public Optional<Error> execute(){
        List<Task> tasks=database.getAllTasks();
        if(tasks.isEmpty()){
            Error error=new Error("User", "User don't have any task");
            return Optional.of(error);
        }
        return Optional.empty();
    }
}
