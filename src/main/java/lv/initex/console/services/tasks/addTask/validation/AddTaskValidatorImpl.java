package lv.initex.console.services.tasks.addTask.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.addTask.AddTaskRequest;
import lv.initex.console.services.tasks.addTask.validation.rules.AddDuplicateTaskTitleRule;
import lv.initex.console.services.tasks.addTask.validation.rules.AddEmptyTitleRule;
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
    public List<TaskListError> validate(AddTaskRequest request) {
        List<TaskListError> errors = new ArrayList<>();
        duplicateTaskTitleRule.execute(request.getTaskTitle()).ifPresent(errors::add);
        emptyTitleRule.execute(request.getTaskTitle()).ifPresent(errors::add);
        return errors;
    }
}
