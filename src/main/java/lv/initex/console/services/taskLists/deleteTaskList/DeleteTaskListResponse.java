package lv.initex.console.services.taskLists.deleteTaskList;

import lv.initex.console.services.TaskListError;

import java.util.List;

public class DeleteTaskListResponse {
    private Long taskListId;
    private String taskListTitle;
    private List<TaskListError> errors;

    public DeleteTaskListResponse(Long taskListId, String taskListTitle, List<TaskListError> errors) {
        this.taskListId = taskListId;
        this.taskListTitle = taskListTitle;
        this.errors = errors;
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
