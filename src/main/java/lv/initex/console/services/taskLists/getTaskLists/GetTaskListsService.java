package lv.initex.console.services.taskLists.getTaskLists;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;

import lv.initex.console.services.taskLists.getTaskLists.validation.GetTaskListValidator;
import lv.initex.web.dtos.TaskListDTO;
import lv.initex.web.dtos.TaskListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class GetTaskListsService {

    @Autowired
    private TaskListRepository database;

    @Autowired
    private GetTaskListValidator validator;

    public List<TaskListResponseDTO> getAllTaskLists(TaskListDTO tasklistDTO) {

        List<TaskList> taskList;
        List<TaskListError> errors = validator.validate(tasklistDTO);
        if (!errors.isEmpty()) {
            return Collections.singletonList(new TaskListResponseDTO(errors));
        }

        taskList = database.findAllByUser(tasklistDTO.getUserId());

        List<TaskListResponseDTO> response = new ArrayList<>();
        for(TaskList t:taskList){
            TaskListResponseDTO taskListResponseDTO=new TaskListResponseDTO(t.getId(),t.getTaskListTitle());
            response.add(taskListResponseDTO);
        }
        return response;
    }
}
