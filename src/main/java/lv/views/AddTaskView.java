package lv.views;

import lv.services.AddTaskService;

import java.util.Scanner;

public class AddTaskView {

        private AddTaskService addTaskService;

        public AddTaskView(AddTaskService addTaskService) {
            this.addTaskService = addTaskService;
        }


        public void execute() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Add new task" + "\n" + "Enter task name");
            String taskName = scanner.nextLine();
            addTaskService.add(taskName);
            System.out.println("You added new task-" + taskName);
        }

}
