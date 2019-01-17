package lv.console.services.taskLists.getTaskLists.validation;

import lv.console.services.TaskListError;
import lv.console.services.taskLists.getTaskLists.PrintTaskListRequest;
import lv.console.services.taskLists.getTaskLists.validation.rules.PrintTaskListEmptyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrintTaskListValidatorImpl implements PrintTaskListValidator {

    @Autowired
    private PrintTaskListEmptyRule printTaskListEmptyRule;

    @Override
    public List<TaskListError> validate(PrintTaskListRequest request) {
        List<TaskListError> errors = new ArrayList<>();
        printTaskListEmptyRule.execute(request.getUser()).ifPresent(errors::add);
        return errors;
    }
}
