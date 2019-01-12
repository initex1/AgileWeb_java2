package lv.services.tasks.addTask;

import lv.services.TaskListError;

import java.util.List;

public class AddTaskResponse {

    private Long taskId;
    private List<TaskListError> errors;

    public AddTaskResponse(Long taskId) {
        this.taskId = taskId;
    }

    public AddTaskResponse(List<TaskListError> errors) {
        this.errors = errors;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public List<TaskListError> getErrors() {
        return errors;
    }

    public void setErrors(List<TaskListError> errors) {
        this.errors = errors;
    }

    public boolean isSuccess() {
        return taskId != null
                && (errors == null || errors.isEmpty()) ;
    }

}