package lv.views;

import lv.services.DeleteTaskService;
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
        String deleteTaskName=scanner.next();
        boolean isDeleted=deleteTaskService.delete(deleteTaskName);
        if(isDeleted){
            System.out.println("Task deleted successfully");}else{
            System.out.println("Oops! Something wrong!");
        }

    }
}
