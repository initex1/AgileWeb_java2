package lv.services.tasks.addTask.validation.rules;

import lv.services.TaskListError;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddEmptyTitleRule {

    public Optional<TaskListError> execute(String title) {

        if (title == null || title.isEmpty()) {
            TaskListError error = new TaskListError("title", "Title field is empty");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}
