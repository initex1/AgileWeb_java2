package lv.initex.console.services.taskLists.getTaskLists.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.web.dtos.TaskListDTO;

import java.util.List;

public interface GetTaskListValidator {
    List<TaskListError> validate(TaskListDTO tasklistDTO);
}
