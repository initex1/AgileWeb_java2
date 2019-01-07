package lv.services.tasks.getTask;

import lv.domain.Task;
import lv.services.TaskListError;

import java.util.List;

public class PrintTaskListResponse {
    private List<Task> tasks;
    private List<TaskListError> errors;



    public PrintTaskListResponse(List<Task> tasks, List<TaskListError> errors) {
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
