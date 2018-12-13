package lv.views;

import lv.services.AddTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddTaskView {

    @Autowired
    private AddTaskService addTaskService;

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add new task" + "\n" + "Enter task name");
        String taskName = scanner.nextLine();
        addTaskService.add(taskName);
        System.out.println("You added new task-" + taskName);
    }

}
