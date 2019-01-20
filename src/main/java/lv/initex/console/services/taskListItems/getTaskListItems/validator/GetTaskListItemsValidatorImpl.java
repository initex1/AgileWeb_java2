package lv.initex.console.services.taskListItems.getTaskListItems.validator;


import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.getTaskListItems.GetTaskListItemsRequest;
import lv.initex.console.services.taskListItems.getTaskListItems.validator.rules.GetTaskListItemEmptyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetTaskListItemsValidatorImpl implements GetTaskListItemsValidator {

    @Autowired
    private GetTaskListItemEmptyRule getTaskListItemEmptyRule;

    @Override
    public List<TaskListError> validate(GetTaskListItemsRequest request) {
        List<TaskListError> errors = new ArrayList<>();
        getTaskListItemEmptyRule.execute(request.getTaskList()).ifPresent(errors::add);
        return errors;
    }
}
