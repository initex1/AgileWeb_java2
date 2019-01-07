package lv.database;

import lv.domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements TaskRepository {

    private List<Task> taskList = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public boolean deleteTask(Task task) {
        return  taskList.remove(task);
    }

    @Override
    public Optional<Task> findTaskByTitle(String taskTitle) {
        return taskList.stream()
                .filter(p -> p.getTaskTitle().equals(taskTitle))
                .findFirst();
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<Task>(taskList);
    }


}
