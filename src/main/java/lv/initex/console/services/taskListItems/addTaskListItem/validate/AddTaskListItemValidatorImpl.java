package lv.initex.console.services.taskListItems.addTaskListItem.validate;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.addTaskListItem.AddTaskListItemRequest;
import lv.initex.console.services.taskListItems.addTaskListItem.validate.rules.AddDuplicateTaskListItemRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddTaskListItemValidatorImpl implements AddTaskListItemValidator {

    @Autowired
    private AddDuplicateTaskListItemRule addDuplicateTaskListItemRule;


    @Override
    public List<TaskListError> validate(AddTaskListItemRequest request) {

        List<TaskListError> errors = new ArrayList<>();
        addDuplicateTaskListItemRule.execute(request.getTaskList(), request.getTask()).ifPresent(errors::add);
        return errors;
    }
}
