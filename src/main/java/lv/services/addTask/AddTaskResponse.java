package lv.services.addTask;

import lv.services.Error;

import java.util.List;

public class AddTaskResponse {

    private Long taskId;
    private List<Error> errors;

    public AddTaskResponse(Long taskId) {
        this.taskId = taskId;
    }

    public AddTaskResponse(List<Error> errors) {
        this.errors = errors;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public boolean isSuccess() {
        return taskId != null
                && (errors == null || errors.isEmpty()) ;
    }

}
