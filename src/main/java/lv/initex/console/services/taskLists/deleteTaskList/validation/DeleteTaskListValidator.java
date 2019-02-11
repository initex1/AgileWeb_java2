package lv.initex.console.services.taskLists.deleteTaskList.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.web.dtos.TaskListDTO;

import java.util.List;

public interface DeleteTaskListValidator {

    List<TaskListError> validate(TaskListDTO taskListDTO);
}
