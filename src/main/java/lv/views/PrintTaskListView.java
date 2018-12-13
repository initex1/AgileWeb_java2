package lv.views;

import lv.domain.Task;
import lv.services.PrintTaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintTaskListView {

    @Autowired
    PrintTaskListService printTaskListService;


    public  void execute(){
        int taskNumber = 1;
        System.out.println("Current user have following tasks:");

        for (Task task : printTaskListService.getAllTasks()) {
            System.out.println(taskNumber + "-" + task.getTaskTitle());
            taskNumber++;
        }
    }
}
