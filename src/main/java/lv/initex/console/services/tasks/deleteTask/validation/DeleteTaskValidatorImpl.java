package lv.initex.console.services.tasks.deleteTask.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.deleteTask.DeleteTaskRequest;
import lv.initex.console.services.tasks.deleteTask.validation.rules.DeleteTaskNotFoundRule;
import lv.initex.console.services.tasks.deleteTask.validation.rules.DeleteTitleIsEmptyRule;
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
    public List<TaskListError> validate(DeleteTaskRequest deleteTaskRequest) {
        List<TaskListError> errors = new ArrayList<>();
        deleteTaskNotFoundRule.execute(deleteTaskRequest.getTaskTitle()).ifPresent(errors::add);
        deleteEmptyTitleRule.execute(deleteTaskRequest.getTaskTitle()).ifPresent(errors::add);
        return errors;
    }
}
