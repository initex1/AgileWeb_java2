package lv.console.services.taskListItems.getTaskListItems.validator;


import lv.console.services.TaskListError;
import lv.console.services.taskListItems.getTaskListItems.PrintTaskListItemsRequest;
import lv.console.services.taskListItems.getTaskListItems.validator.rules.PrintTaskListItemEmptyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrintTaskListitemsValidatorImpl implements PrintTaskListItemsValidator {

    @Autowired
    private PrintTaskListItemEmptyRule printTaskListItemEmptyRule;

    @Override
    public List<TaskListError> validate(PrintTaskListItemsRequest request) {
        List<TaskListError> errors = new ArrayList<>();
        printTaskListItemEmptyRule.execute(request.getTaskList()).ifPresent(errors::add);
        return errors;
    }
}
