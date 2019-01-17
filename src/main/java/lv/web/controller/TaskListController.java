package lv.web.controller;


import lv.console.domain.User;
import lv.console.services.taskLists.addTaskList.AddTaskListRequest;
import lv.console.services.taskLists.addTaskList.AddTaskListResponse;
import lv.console.services.taskLists.addTaskList.AddTaskListService;
import lv.console.services.taskLists.deleteTaskList.DeleteTaskListRequest;
import lv.console.services.taskLists.deleteTaskList.DeleteTaskListResponse;
import lv.console.services.taskLists.deleteTaskList.DeleteTaskListService;
import lv.console.services.taskLists.getTaskLists.PrintTaskListRequest;
import lv.console.services.taskLists.getTaskLists.PrintTaskListResponse;
import lv.console.services.taskLists.getTaskLists.PrintTaskListsService;
import lv.web.dtos.TaskListDTO;
import lv.web.dtos.UserDTO;
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
    private PrintTaskListsService printTaskListsService;

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
    public PrintTaskListResponse getAllTaskLists(@RequestBody TaskListDTO taskListDTO) {

        PrintTaskListRequest request = new PrintTaskListRequest(taskListDTO.getUser());
        PrintTaskListResponse response = printTaskListsService.getAllTaskLists(request);
        return response;
    }

}
