package lv.services;

import lv.Database.Database;
import lv.domain.Task;

public class AddTaskService {
    private Database database;

    public AddTaskService(Database database) {
        this.database = database;
    }

    public void add(String title) {
        Task task = new Task();
        task.setTaskTitle(title);
        database.addTask(task);
    }
}
