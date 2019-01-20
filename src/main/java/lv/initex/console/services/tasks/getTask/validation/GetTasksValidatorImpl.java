package lv.initex.console.services.tasks.getTask.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.getTask.validation.rules.GetTasksEmptyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetTasksValidatorImpl implements GetTasksValidator {

    @Autowired
    private GetTasksEmptyRule getTaskListEmptyRule;

    @Override
    public List<TaskListError> validate() {
        List<TaskListError> errors = new ArrayList<>();
        getTaskListEmptyRule.execute().ifPresent(errors::add);
        return errors;
    }
}
