package lv.initex.console.services.taskLists.addTaskList;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.addTaskList.validation.AddTaskListValidator;
import lv.initex.web.dtos.TaskListDTO;
import lv.initex.web.dtos.TaskListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddTaskListService {

    @Autowired
    private TaskListRepository database;

    @Autowired
    private AddTaskListValidator validator;

    public TaskListResponseDTO add(TaskListDTO taskListDTO) {
        List<TaskListError> errors = validator.validate(taskListDTO);
        if (!errors.isEmpty()) {
            return new TaskListResponseDTO(errors);
        }
        User user = new User();
        user.setId(taskListDTO.getUserId());
        TaskList taskList = new TaskList();
        taskList.setUser(user);
        taskList.setTaskTitle(taskListDTO.getTaskListTitle());
        database.save(taskList);
        return new TaskListResponseDTO(taskList.getId(), taskList.getTaskListTitle(), errors);

    }
}
