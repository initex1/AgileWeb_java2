package lv.initex.console.views;

import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.getTask.GetTasksResponse;
import lv.initex.console.services.tasks.getTask.GetTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintTaskListView {

    @Autowired
    GetTasksService printTasksService;


    public void execute() {


        GetTasksResponse response = printTasksService.getAllTasks();
        if (response.isSuccess()) {
            int taskNumber = 1;
            System.out.println("Current user have following tasks:");
            for (Task task : printTasksService.getAllTasks().getTasks()) {
                System.out.println(taskNumber + "-" + task.getTaskTitle());
                taskNumber++;
            }
        } else {
            for (TaskListError error : response.getErrors()) {
                System.out.println("Error:" + error.getDescription());
            }
        }
    }
}
