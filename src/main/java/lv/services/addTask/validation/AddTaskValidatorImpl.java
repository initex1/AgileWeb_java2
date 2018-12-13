package lv.services.addTask.validation;

import lv.services.Error;
import lv.services.addTask.AddTaskRequest;
import lv.services.addTask.validation.rules.AddDuplicateTaskTitleRule;
import lv.services.addTask.validation.rules.AddEmptyTitleRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddTaskValidatorImpl implements AddTaskValidator {

    @Autowired
    private AddDuplicateTaskTitleRule duplicateTaskTitleRule;

    @Autowired
    private AddEmptyTitleRule emptyTitleRule;

    @Override
    public List<Error> validate(AddTaskRequest request) {
        List<Error> errors = new ArrayList<>();
        duplicateTaskTitleRule.execute(request.getTaskTitle()).ifPresent(errors::add);
        emptyTitleRule.execute(request.getTaskTitle()).ifPresent(errors::add);
        return errors;
    }
}
