package lv.initex.web.dtos;

public class TaskListDTO {

    private Long id;
    private String listTitle;


    public TaskListDTO(Long id){
        this.id = id;
    }

    public TaskListDTO(Long id,  String listTitle) {
        this.id = id;
        this.listTitle=listTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

}
