package lv.initex.console.services.taskLists.getTaskLists.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.getTaskLists.validation.rules.GetTaskListEmptyRule;
import lv.initex.web.dtos.TaskListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetTaskListValidatorImpl implements GetTaskListValidator {

    @Autowired
    private GetTaskListEmptyRule getTaskListEmptyRule;

    @Override
    public List<TaskListError> validate(TaskListDTO tasklistDTO) {
        List<TaskListError> errors = new ArrayList<>();
        getTaskListEmptyRule.execute(tasklistDTO.getUserId()).ifPresent(errors::add);
        return errors;
    }
}
