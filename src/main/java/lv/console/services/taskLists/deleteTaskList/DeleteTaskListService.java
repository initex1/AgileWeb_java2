package lv.console.services.taskLists.deleteTaskList;

import lv.console.database.TaskListRepository;
import lv.console.domain.TaskList;
import lv.console.services.TaskListError;
import lv.console.services.taskLists.deleteTaskList.validation.DeleteTaskListValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteTaskListService {

    @Autowired
    private TaskListRepository database;

    @Autowired
    private DeleteTaskListValidator validator;

    public DeleteTaskListResponse delete(DeleteTaskListRequest request) {

        List<TaskListError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteTaskListResponse(errors);
        }
        TaskList taskList = database.findByUserAndTitle(request.getUser(), request.getTaskListTitle()).get();

        database.deleteTaskList(taskList);
        return new DeleteTaskListResponse(taskList.getId());

    }

}
