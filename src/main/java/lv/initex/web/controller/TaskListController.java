package lv.initex.web.controller;


import lv.initex.console.services.taskLists.addTaskList.AddTaskListRequest;
import lv.initex.console.services.taskLists.addTaskList.AddTaskListResponse;
import lv.initex.console.services.taskLists.addTaskList.AddTaskListService;
import lv.initex.console.services.taskLists.deleteTaskList.DeleteTaskListRequest;
import lv.initex.console.services.taskLists.deleteTaskList.DeleteTaskListResponse;
import lv.initex.console.services.taskLists.deleteTaskList.DeleteTaskListService;
import lv.initex.console.services.taskLists.getTaskLists.GetTaskListRequest;
import lv.initex.console.services.taskLists.getTaskLists.GetTaskListResponse;
import lv.initex.console.services.taskLists.getTaskLists.GetTaskListsService;
import lv.initex.web.dtos.TaskListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskListController {

    @Autowired
    private AddTaskListService addTaskListService;

    @Autowired
    private DeleteTaskListService deleteTaskListService;

    @Autowired
    private GetTaskListsService printTaskListsService;

    @ResponseBody
    @PostMapping(value = "/users/taskLists")
    public ResponseEntity<TaskListDTO> add(@RequestBody TaskListDTO taskListDTO) {

        AddTaskListRequest request = new AddTaskListRequest(
                taskListDTO.getUser(), taskListDTO.getListTitle()
        );
        AddTaskListResponse response = addTaskListService.add(request);
        taskListDTO.setId(response.getTaskListId());
        return ResponseEntity.ok(taskListDTO);
    }

    @ResponseBody
    @DeleteMapping(value = "/users/taskLists")
    public DeleteTaskListResponse delete(@RequestBody TaskListDTO taskListDTO) {
        DeleteTaskListRequest request = new DeleteTaskListRequest(
                taskListDTO.getUser(), taskListDTO.getListTitle()
        );
        DeleteTaskListResponse response = deleteTaskListService.delete(request);
        return response;
    }

    @ResponseBody
    @GetMapping(value = "/users/taskLists")
    public GetTaskListResponse getAllTaskLists(@RequestBody TaskListDTO taskListDTO) {

        GetTaskListRequest request = new GetTaskListRequest(taskListDTO.getUser());
        GetTaskListResponse response = printTaskListsService.getAllTaskLists(request);
        return response;
    }

}
