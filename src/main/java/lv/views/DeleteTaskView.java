package lv.views;

import lv.domain.Task;
import lv.services.Error;
import lv.services.deleteTask.DeleteTaskRequest;
import lv.services.deleteTask.DeleteTaskResponse;
import lv.services.deleteTask.DeleteTaskService;
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
            for (Error error : response.getErrors()) {
                System.out.println("Error:" + error.getDescription());
            }
        }

    }

    private void printTasks() {
        for (Task task : deleteTaskService.getAllTasks()) {
            System.out.println(task.getTaskTitle() );
        }
    }
}
