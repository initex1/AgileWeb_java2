package lv.services;

import lv.Database.TaskRepository;
import lv.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddTaskService {

    @Autowired
    private TaskRepository database;


    public void add(String title) {
        Task task = new Task();
        task.setTaskTitle(title);
        database.addTask(task);
    }
}
