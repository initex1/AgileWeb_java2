package lv.initex.console.services.taskLists.getTaskLists.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.getTaskLists.GetTaskListRequest;
import lv.initex.console.services.taskLists.getTaskLists.validation.rules.GetTaskListEmptyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetTaskListValidatorImpl implements GetTaskListValidator {

    @Autowired
    private GetTaskListEmptyRule getTaskListEmptyRule;

    @Override
    public List<TaskListError> validate(GetTaskListRequest request) {
        List<TaskListError> errors = new ArrayList<>();
        getTaskListEmptyRule.execute(request.getUser()).ifPresent(errors::add);
        return errors;
    }
}
