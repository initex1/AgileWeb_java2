package lv.initex.web.dtos;

import lv.initex.console.domain.User;

public class TaskListDTO {

    private Long id;
    private User user;
    private String listTitle;

    public TaskListDTO() {
    }

    public TaskListDTO(Long id, User user, String listTitle) {
        this.id = id;
        this.user = user;
        this.listTitle = listTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }
}
