package lv.console.services.taskLists.addTaskList;

import lv.console.services.TaskListError;

import java.util.List;

public class AddTaskListResponse {
    private Long taskListId;
    private List<TaskListError> errors;

    public AddTaskListResponse(Long taskListId) {
        this.taskListId = taskListId;
    }

    public AddTaskListResponse(List<TaskListError> errors) {
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
