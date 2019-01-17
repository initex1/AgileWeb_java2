package lv.console.services.tasks.getTask;

import lv.console.domain.Task;
import lv.console.services.TaskListError;

import java.util.List;

public class PrintTasksResponse {
    private List<Task> tasks;
    private List<TaskListError> errors;



    public PrintTasksResponse(List<Task> tasks, List<TaskListError> errors) {
        this.tasks = tasks;
        this.errors = errors;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<TaskListError> getErrors() {
        return errors;
    }

    public void setErrors(List<TaskListError> errors) {
        this.errors = errors;
    }

    public boolean isSuccess() {
        return errors == null || errors.isEmpty();
    }
}
