package lv.views;

import lv.domain.Task;
import lv.services.PrintTaskListService;

public class PrintTaskListView {
    PrintTaskListService printTaskListService;

    public PrintTaskListView(PrintTaskListService printTaskListService) {
        this.printTaskListService = printTaskListService;
    }

    public  void execute(){
        int taskNumber = 1;
        System.out.println("Current user have following tasks:");

        for (Task task : printTaskListService.getAllTasks()) {
            System.out.println(taskNumber + "-" + task.getTaskTitle());
            taskNumber++;
        }
    }
}
