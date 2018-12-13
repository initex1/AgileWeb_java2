package lv;

import lv.Database.Database;
import lv.Database.InMemoryDatabase;
import lv.services.AddTaskService;
import lv.services.DeleteTaskService;
import lv.services.PrintTaskListService;
import lv.views.AddTaskView;
import lv.views.DeleteTaskView;
import lv.views.PrintTaskListView;

import java.util.Scanner;

public class ToDoManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Database database = new InMemoryDatabase();
        AddTaskService addTaskService = new AddTaskService(database);
        DeleteTaskService deleteTaskService = new DeleteTaskService(database);
        PrintTaskListService printTaskListService = new PrintTaskListService(database);

        AddTaskView addTaskView = new AddTaskView(addTaskService);
        DeleteTaskView deleteTaskView = new DeleteTaskView(deleteTaskService);
        PrintTaskListView printTaskListView = new PrintTaskListView(printTaskListService);

        System.out.println("Hi! this is system for creating TO-Do list");
        printMenuOptions();

        int userInput = -1;

        while (userInput != 4) {
            userInput = getValidMenuInput(scanner);     //Getting valid selection
            switch (userInput) {
                case 1:
                    addTaskView.execute();
                    break;
                case 2:
                    deleteTaskView.execute();
                    break;
                case 3:
                    printTaskListView.execute();
                    break;
                case 4:
                    System.out.println("Terminating program");
                    break;
            }
        }
    }

    private static void printMenuOptions() {
        System.out.println("1-Add task" + "\n" + "2-Delete task" + "\n" + "3-Print task list" + "\n" + "4-Exit program");
    }

    private static int getValidMenuInput(Scanner scanner) {
        boolean isValidInput = false;
        int tmpInput = -1;
        while (!isValidInput) {
            if (scanner.hasNextInt()) {
                tmpInput = scanner.nextInt();
                if (tmpInput > 0 && tmpInput < 5) {
                    return tmpInput;                                //in this case returned valid selection
                } else {
                    System.out.println("Selection is out of range");
                    printMenuOptions();
                }
            } else {
                System.out.println("Give valid integer selection!");
                scanner.next();
                printMenuOptions();
            }
        }
        return tmpInput;
    }
}
