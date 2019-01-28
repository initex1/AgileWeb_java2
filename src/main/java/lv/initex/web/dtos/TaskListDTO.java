package lv.initex.web.dtos;

import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;

import java.util.List;

public class TaskListDTO {

    private Long id;
    private Long userId;
    private String listTitle;
    private List<TaskListError> error;

    public TaskListDTO(Long id){
        this.id = id;
    }

    public TaskListDTO(Long id, Long userId, String listTitle) {
        this.id = id;
        this.userId=userId;
        this.listTitle=listTitle;
    }

    public TaskListDTO(List<TaskListError> error) {
        this.error = error;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public List<TaskListError> getError() {
        return error;
    }

    public void setError(List<TaskListError> error) {
        this.error = error;
    }
}
