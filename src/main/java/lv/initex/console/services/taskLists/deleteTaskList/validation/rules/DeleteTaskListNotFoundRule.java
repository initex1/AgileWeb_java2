package lv.initex.console.services.taskLists.deleteTaskList.validation.rules;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteTaskListNotFoundRule {

    @Autowired
    private TaskListRepository database;

    public Optional<TaskListError> execute(User user, String taskList) {
        if(user!=null&&taskList!=null){
            Optional<TaskList> foundTaskList=database.findByUserAndTitle(user, taskList);
            if(!foundTaskList.isPresent()){
                TaskListError error = new TaskListError("TaskList", "No such taskList user!");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
