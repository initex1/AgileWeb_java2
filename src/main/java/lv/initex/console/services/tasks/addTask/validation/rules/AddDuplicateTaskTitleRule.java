package lv.initex.console.services.tasks.addTask.validation.rules;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddDuplicateTaskTitleRule {


    private TaskRepository database;

    public AddDuplicateTaskTitleRule(TaskRepository database) {
        this.database = database;
    }

    public Optional<TaskListError> execute(String title) {
        if (title != null) {
            Optional<Task> task = database.findTaskByTitle(title);
            if (task.isPresent()) {
                TaskListError error = new TaskListError("title", "Duplicate task exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}



