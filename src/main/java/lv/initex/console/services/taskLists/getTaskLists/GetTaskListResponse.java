package lv.initex.console.services.taskLists.getTaskLists;

import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;

import java.util.List;

public class GetTaskListResponse {

    private List<TaskList> taskList;
    private List<TaskListError> errors;

    public GetTaskListResponse(List<TaskList> taskList, List<TaskListError> errors) {
        this.taskList = taskList;
        this.errors = errors;
    }

    public List<TaskList> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskList> taskList) {
        this.taskList = taskList;
    }

    public List<TaskListError> getErrors() {
        return errors;
    }

    public void setErrors(List<TaskListError> errors) {
        this.errors = errors;
    }
}
