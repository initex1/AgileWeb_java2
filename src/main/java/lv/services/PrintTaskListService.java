package lv.services;

import lv.Database.Database;
import lv.domain.Task;

import java.util.List;

public class PrintTaskListService {
    Database database;

    public PrintTaskListService(Database database) {
        this.database = database;
    }

    public List<Task> getAllTasks(){
        return database.getAllTasks();
    }
}
