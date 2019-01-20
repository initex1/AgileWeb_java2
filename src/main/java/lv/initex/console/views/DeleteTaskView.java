package lv.initex.console.views;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.deleteTask.DeleteTaskRequest;
import lv.initex.console.services.tasks.deleteTask.DeleteTaskResponse;
import lv.initex.console.services.tasks.deleteTask.DeleteTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteTaskView {

    @Autowired
    DeleteTaskService deleteTaskService ;



    public void execute() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Which task to delete?");
        String deleteTaskName=scanner.nextLine();


        DeleteTaskRequest request = new DeleteTaskRequest(deleteTaskName);
        DeleteTaskResponse response = deleteTaskService.delete(request);

        if (response.isSuccess()) {
            System.out.println("You successfully deleted task with ID:" + response.getTaskId()+"\n");
        } else {
            for (TaskListError error : response.getErrors()) {
                System.out.println("Error:" + error.getDescription());
            }
        }

    }


}
