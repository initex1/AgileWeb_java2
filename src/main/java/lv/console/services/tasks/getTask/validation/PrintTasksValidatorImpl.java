package lv.console.services.tasks.getTask.validation;

import lv.console.services.TaskListError;
import lv.console.services.tasks.getTask.validation.rules.PrintTasksEmptyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrintTasksValidatorImpl implements PrintTasksValidator {

    @Autowired
    private PrintTasksEmptyRule printTaskListEmptyRule;

    @Override
    public List<TaskListError> validate() {
        List<TaskListError> errors = new ArrayList<>();
        printTaskListEmptyRule.execute().ifPresent(errors::add);
        return errors;
    }
}
