package lv.initex.console.services.taskLists.deleteTaskList;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.deleteTaskList.validation.DeleteTaskListValidator;
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
        TaskList taskList = database.findByUserIdAndTitle(request.getUserId(), request.getTaskListTitle()).get();
        database.delete(taskList);
        return new DeleteTaskListResponse(taskList.getId(), taskList.getTaskListTitle(), errors);

    }

}
