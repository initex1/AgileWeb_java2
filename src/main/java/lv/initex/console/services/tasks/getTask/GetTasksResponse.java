package lv.initex.console.services.tasks.getTask;

import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;

import java.util.List;

public class GetTasksResponse {
    private List<Task> tasks;
    private List<TaskListError> errors;



    public GetTasksResponse(List<Task> tasks, List<TaskListError> errors) {
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
