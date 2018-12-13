package lv.services.deleteTask.validation;

import lv.services.Error;
import lv.services.deleteTask.DeleteTaskRequest;
import lv.services.deleteTask.validation.rules.DeleteTaskNotFoundRule;
import lv.services.deleteTask.validation.rules.DeleteTitleIsEmptyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeleteTaskValidatorImpl implements DeleteTaskValidator {

    @Autowired
    private DeleteTaskNotFoundRule deleteTaskNotFoundRule;

    @Autowired
    private DeleteTitleIsEmptyRule deleteEmptyTitleRule;

    @Override
    public List<Error> validate(DeleteTaskRequest deleteTaskRequest) {
        List<Error> errors = new ArrayList<>();
        deleteTaskNotFoundRule.execute(deleteTaskRequest.getTaskTitle()).ifPresent(errors::add);
        deleteEmptyTitleRule.execute(deleteTaskRequest.getTaskTitle()).ifPresent(errors::add);
        return errors;
    }
}
