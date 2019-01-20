package lv.initex.console.services.tasks.deleteTask.validation.rules;

import lv.initex.console.services.TaskListError;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class DeleteTitleIsEmptyRule {

    public Optional<TaskListError> execute(String title) {

        if (title == null || title.isEmpty()) {
            TaskListError error = new TaskListError("title", "Delete task field is empty!");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}

