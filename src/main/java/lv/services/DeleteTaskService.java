package lv.services;

import lv.Database.Database;
import lv.domain.Task;

import java.util.Optional;

public class DeleteTaskService {
    Database database;

    public DeleteTaskService(Database database) {
        this.database = database;
    }

    public boolean delete(String deleteTaskName) {
        Optional<Task> foundTask = database.findTaskByTitle(deleteTaskName);
        if (foundTask.isPresent()) {
            Task task = foundTask.get();
            return database.deleteTask(task);
        } else {
            return false;
        }
    }
}
