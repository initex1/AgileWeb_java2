package lv.services.getTask;

import lv.domain.Task;
import lv.services.Error;

import java.util.List;

public class PrintTaskListResponse {
    private List<Task> tasks;
    private List<Error> errors;



    public PrintTaskListResponse(List<Task> tasks, List<Error> errors) {
        this.tasks = tasks;
        this.errors = errors;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public boolean isSuccess() {
        return errors == null || errors.isEmpty();
    }
}
