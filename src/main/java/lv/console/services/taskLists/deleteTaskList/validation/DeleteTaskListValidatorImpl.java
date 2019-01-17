package lv.console.services.taskLists.deleteTaskList.validation;

import lv.console.services.TaskListError;
import lv.console.services.taskLists.deleteTaskList.DeleteTaskListRequest;
import lv.console.services.taskLists.deleteTaskList.validation.rules.DeleteTaskListNoUserRule;
import lv.console.services.taskLists.deleteTaskList.validation.rules.DeleteTaskListNotFoundRule;
import lv.console.services.taskLists.deleteTaskList.validation.rules.DeleteTaskListTitleEmtyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeleteTaskListValidatorImpl implements DeleteTaskListValidator {

    @Autowired
    private DeleteTaskListTitleEmtyRule deleteTaskListTitleEmtyRule;

    @Autowired
    private DeleteTaskListNoUserRule deleteTaskListNoUserRule;

    @Autowired
    private DeleteTaskListNotFoundRule deleteTaskListNotFoundRule;


    @Override
    public List<TaskListError> validate(DeleteTaskListRequest request) {
        List<TaskListError> errors = new ArrayList<>();
        deleteTaskListTitleEmtyRule.execute(request.getTaskListTitle()).ifPresent(errors::add);
        deleteTaskListNoUserRule.execute(request.getUser()).ifPresent(errors::add);
        deleteTaskListNotFoundRule.execute(request.getUser(), request.getTaskListTitle()).ifPresent(errors::add);
        return errors;
    }
}
