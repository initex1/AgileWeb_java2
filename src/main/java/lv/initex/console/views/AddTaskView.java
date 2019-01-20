package lv.initex.console.views;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.addTask.AddTaskRequest;
import lv.initex.console.services.tasks.addTask.AddTaskResponse;
import lv.initex.console.services.tasks.addTask.AddTaskService;
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
        String taskTitle = scanner.nextLine();

        AddTaskRequest request = new AddTaskRequest(taskTitle);
        AddTaskResponse response = addTaskService.add(request);
        if (response.isSuccess()) {
            System.out.println("You added new task-" + taskTitle + "\n");
        } else {
            for (TaskListError error : response.getErrors()) {
                System.out.println("Error:" + error.getDescription());
            }
        }

    }
}
