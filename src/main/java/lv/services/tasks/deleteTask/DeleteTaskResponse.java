package lv.services.tasks.deleteTask;

import lv.services.TaskListError;

import java.util.List;

public class DeleteTaskResponse {

    private Long taskId;
    private List<TaskListError> errors;

    public DeleteTaskResponse(Long taskId) {
        this.taskId = taskId;
    }

    public DeleteTaskResponse(List<TaskListError> errors) {
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
