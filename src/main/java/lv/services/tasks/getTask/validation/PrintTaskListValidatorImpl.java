package lv.services.tasks.getTask.validation;

import lv.services.TaskListError;
import lv.services.tasks.getTask.validation.rules.PrintTaskListEmptyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrintTaskListValidatorImpl implements PrintTaskListValidator {

    @Autowired
    private PrintTaskListEmptyRule printTaskListEmptyRule;

    @Override
    public List<TaskListError> validate() {
        List<TaskListError> errors = new ArrayList<>();
        printTaskListEmptyRule.execute().ifPresent(errors::add);
        return errors;
    }
}
