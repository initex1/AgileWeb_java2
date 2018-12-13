package lv.services.deleteTask.validation.rules;

import lv.services.Error;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class DeleteTitleIsEmptyRule {

    public Optional<Error> execute(String title) {

        if (title == null || title.isEmpty()) {
            Error error = new Error("title", "Delete task field is empty!");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}

