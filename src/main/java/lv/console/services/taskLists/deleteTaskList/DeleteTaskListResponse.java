package lv.console.services.taskLists.deleteTaskList;

import lv.console.services.TaskListError;

import java.util.List;

public class DeleteTaskListResponse {
    private Long taskListId;
    private List<TaskListError> errors;

    public DeleteTaskListResponse(Long taskListId) {
        this.taskListId = taskListId;
    }

    public DeleteTaskListResponse(List<TaskListError> errors) {
        this.errors = errors;
    }

    public Long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Long taskListId) {
        this.taskListId = taskListId;
    }

    public List<TaskListError> getErrors() {
        return errors;
    }

    public void setErrors(List<TaskListError> errors) {
        this.errors = errors;
    }
}
