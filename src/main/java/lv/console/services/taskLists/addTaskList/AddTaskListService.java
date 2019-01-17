package lv.console.services.taskLists.addTaskList;

import lv.console.database.TaskListRepository;
import lv.console.domain.TaskList;
import lv.console.services.TaskListError;
import lv.console.services.taskLists.addTaskList.validation.AddTaskListValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddTaskListService {

    @Autowired
    private TaskListRepository database;

    @Autowired
    private AddTaskListValidator validator;

    public AddTaskListResponse add(AddTaskListRequest request){
        List<TaskListError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AddTaskListResponse(errors);
        }
        TaskList taskList = new TaskList();
        taskList.setUser(request.getUser());
        taskList.setTaskTitle(request.getTaskListTitle());
        database.addTaskList(taskList);

        return new AddTaskListResponse(taskList.getId());
    }
}
