package lv.console.views;

import lv.console.domain.Task;
import lv.console.services.TaskListError;
import lv.console.services.tasks.getTask.PrintTaskListResponse;
import lv.console.services.tasks.getTask.PrintTaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintTaskListView {

    @Autowired
    PrintTaskListService printTaskListService;


    public void execute() {


        PrintTaskListResponse response = printTaskListService.getAllTasks();
        if (response.isSuccess()) {
            int taskNumber = 1;
            System.out.println("Current user have following tasks:");
            for (Task task : printTaskListService.getAllTasks().getTasks()) {
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
