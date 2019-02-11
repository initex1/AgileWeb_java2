package lv.initex.console.services.taskLists.deleteTaskList;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.deleteTaskList.validation.DeleteTaskListValidator;
import lv.initex.web.dtos.TaskListDTO;
import lv.initex.web.dtos.TaskListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteTaskListService {

    @Autowired
    private TaskListRepository database;

    @Autowired
    private DeleteTaskListValidator validator;

    public TaskListResponseDTO delete(TaskListDTO taskListDTO) {

        List<TaskListError> errors = validator.validate(taskListDTO);

        if (!errors.isEmpty()) {
            return new TaskListResponseDTO(errors);
        }
        TaskList taskList = database.findByUserIdAndTitle(taskListDTO.getUserId(), taskListDTO.getTaskListTitle()).get();
        database.delete(taskList);
        return new TaskListResponseDTO(taskList.getId(), taskList.getTaskListTitle(), errors);

    }

}
