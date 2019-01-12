package lv.console.domain;

import javax.persistence.*;

@Entity
@Table(name = "task_lists")
public class TaskList {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,unique = true)
    private User user;

    @Column(name = "title", nullable = false)
    private String listTitle;

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

    public String getTaskTitle() {
        return listTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.listTitle = taskTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskList that = (TaskList) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (listTitle != null ? !listTitle.equals(that.listTitle) : that.listTitle != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (listTitle != null ? listTitle.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", title='" + listTitle + '\'' +
                ", user=" + user +
                '}';
    }

}
