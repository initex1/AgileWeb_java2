package lv.console.views;

import lv.console.domain.Task;
import lv.console.services.TaskListError;
import lv.console.services.tasks.getTask.PrintTasksResponse;
import lv.console.services.tasks.getTask.PrintTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintTaskListView {

    @Autowired
    PrintTasksService printTasksService;


    public void execute() {


        PrintTasksResponse response = printTasksService.getAllTasks();
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
