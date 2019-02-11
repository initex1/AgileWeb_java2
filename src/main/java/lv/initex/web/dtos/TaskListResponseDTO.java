package lv.initex.web.dtos;

import lv.initex.console.services.TaskListError;

import java.util.List;

public class TaskListResponseDTO {
    private Long taskListId;
    private String taskListTitle;
    private List<TaskListError> errors;

    public TaskListResponseDTO(Long taskListId, String taskListTitle) {
        this.taskListId = taskListId;
        this.taskListTitle = taskListTitle;
    }

    public TaskListResponseDTO(Long taskListId, String taskListTitle, List<TaskListError> errors) {
        this.taskListId = taskListId;
        this.taskListTitle = taskListTitle;
        this.errors = errors;
    }

    public TaskListResponseDTO(List<TaskListError> errors) {
        this.errors = errors;
    }

    public Long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Long taskListId) {
        this.taskListId = taskListId;
    }

    public String getTaskListTitle() {
        return taskListTitle;
    }

    public void setTaskListTitle(String taskListTitle) {
        this.taskListTitle = taskListTitle;
    }

    public List<TaskListError> getErrors() {
        return errors;
    }

    public void setErrors(List<TaskListError> errors) {
        this.errors = errors;
    }
}
