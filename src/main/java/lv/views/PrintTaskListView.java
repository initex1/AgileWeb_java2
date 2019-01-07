package lv.views;

import lv.domain.Task;
import lv.services.TaskListError;
import lv.services.tasks.getTask.PrintTaskListResponse;
import lv.services.tasks.getTask.PrintTaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintTaskListView {

    @Autowired
    PrintTaskListService printTaskListService;


    public void execute() {

        System.out.println("Current user have following tasks:");
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
