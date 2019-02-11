package lv.initex.console.services.taskLists.addTaskList.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.web.dtos.TaskListDTO;

import java.util.List;

public interface AddTaskListValidator {
    List<TaskListError> validate(TaskListDTO taskListDTO);
}
