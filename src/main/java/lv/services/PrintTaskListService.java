package lv.services;

import lv.Database.TaskRepository;
import lv.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrintTaskListService {

    @Autowired
    TaskRepository database;


    public List<Task> getAllTasks() {
        return database.getAllTasks();
    }
}
