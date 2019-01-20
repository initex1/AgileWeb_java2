package lv.initex.console.services.taskLists.addTaskList.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.addTaskList.AddTaskListRequest;
import lv.initex.console.services.taskLists.addTaskList.validation.rules.AddDuplicateTaskListTitleRule;
import lv.initex.console.services.taskLists.addTaskList.validation.rules.AddEmptyTaskListTitleRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddTaskListValidatorImpl implements AddTaskListValidator{

    @Autowired
    private AddDuplicateTaskListTitleRule addDuplicateTaskListtitleRule;

    @Autowired
    private AddEmptyTaskListTitleRule addEmptyTaskListTitleRule;


    @Override
    public List<TaskListError> validate(AddTaskListRequest request) {
        List<TaskListError> errors = new ArrayList<>();
        addDuplicateTaskListtitleRule.execute(request.getUser(), request.getTaskListTitle()).ifPresent(errors::add);
        addEmptyTaskListTitleRule.execute(request.getTaskListTitle()).ifPresent(errors::add);
        return errors;
    }
}
