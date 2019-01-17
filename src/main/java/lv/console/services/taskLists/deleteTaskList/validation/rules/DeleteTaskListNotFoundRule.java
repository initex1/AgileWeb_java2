package lv.console.services.taskLists.deleteTaskList.validation.rules;

import lv.console.database.TaskListRepository;
import lv.console.domain.TaskList;
import lv.console.domain.User;
import lv.console.services.TaskListError;
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
