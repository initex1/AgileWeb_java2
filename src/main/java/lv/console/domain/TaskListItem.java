package lv.console.domain;

import javax.persistence.*;

@Entity
@Table(name="task_list_items")
public class TaskListItem {

    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name="task_list_id", nullable = false)
    private TaskList taskList;


    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList= taskList;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskListItem that = (TaskListItem) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (taskList != null ? !taskList.equals(that.taskList) : that.taskList != null) return false;
        if (task != null ? !task.equals(that.task) : that.task != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (taskList != null ? taskList.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskListItem{" +
                "id=" + id +
                ", taskList=" + taskList +
                ", product=" + task +
                ", status=" + status +
                '}';
    }
}
