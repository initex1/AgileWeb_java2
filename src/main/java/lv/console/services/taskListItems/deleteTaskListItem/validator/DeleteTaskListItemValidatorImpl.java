package lv.console.services.taskListItems.deleteTaskListItem.validator;

import lv.console.services.TaskListError;
import lv.console.services.taskListItems.deleteTaskListItem.DeleteTaskListItemRequest;
import lv.console.services.taskListItems.deleteTaskListItem.validator.rules.DeleteTaskListItemNotFoundRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeleteTaskListItemValidatorImpl implements DeleteTaskListItemValidator {

    @Autowired
    private DeleteTaskListItemNotFoundRule deleteTaskListItemNotFoundRule;


    @Override
    public List<TaskListError> validate(DeleteTaskListItemRequest request) {
        List<TaskListError> errors = new ArrayList<>();
        deleteTaskListItemNotFoundRule.execute(request.getTaskList(), request.getTask()).ifPresent(errors::add);
        return errors;
    }
}
