package lv.services;

import lv.Database.TaskRepository;
import lv.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteTaskService {

    @Autowired
    TaskRepository database;


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
