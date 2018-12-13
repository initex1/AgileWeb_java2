package lv.services.addTask.validation.rules;

import lv.database.TaskRepository;
import lv.domain.Task;
import lv.services.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddDuplicateTaskTitleRule {

    @Autowired
    private TaskRepository database;

    public AddDuplicateTaskTitleRule(TaskRepository database) {
        this.database = database;
    }

    public Optional<Error> execute(String title) {
        if (title != null) {
            Optional<Task> task = database.findTaskByTitle(title);
            if (task.isPresent()) {
                Error error = new Error("title", "Duplicate task exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}



