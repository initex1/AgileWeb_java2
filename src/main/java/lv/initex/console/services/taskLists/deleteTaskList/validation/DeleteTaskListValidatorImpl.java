package lv.initex.console.services.taskLists.deleteTaskList.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.deleteTaskList.validation.rules.DeleteTaskListNoUserRule;
import lv.initex.console.services.taskLists.deleteTaskList.validation.rules.DeleteTaskListNotFoundRule;
import lv.initex.console.services.taskLists.deleteTaskList.validation.rules.DeleteTaskListTitleEmtyRule;
import lv.initex.web.dtos.TaskListDTO;
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
    public List<TaskListError> validate(TaskListDTO taskListDTO) {
        List<TaskListError> errors = new ArrayList<>();
        deleteTaskListTitleEmtyRule.execute(taskListDTO.getTaskListTitle()).ifPresent(errors::add);
        deleteTaskListNoUserRule.execute(taskListDTO.getUserId()).ifPresent(errors::add);
        deleteTaskListNotFoundRule.execute(taskListDTO.getUserId(), taskListDTO.getTaskListTitle()).ifPresent(errors::add);
        return errors;
    }
}
