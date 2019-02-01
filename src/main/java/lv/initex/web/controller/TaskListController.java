package lv.initex.web.controller;


import lv.initex.console.domain.TaskList;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskListController {

    @Autowired
    private AddTaskListService addTaskListService;

    @Autowired
    private DeleteTaskListService deleteTaskListService;

    @Autowired
    private GetTaskListsService getTaskListsService;


    @PostMapping(value = "/users/{id}/taskList")
    public ResponseEntity<TaskListDTO> add(@PathVariable("id") Long userId, @RequestParam("title") String taskListTitle) throws ValidationError {

        AddTaskListRequest request = new AddTaskListRequest(userId, taskListTitle);
        AddTaskListResponse response = addTaskListService.add(request);
        if (!response.getErrors().isEmpty()) {
            throw new ValidationError(response.getErrors());
        }
        return ResponseEntity.ok(new TaskListDTO(response.getTaskListId(), response.getTaskListTitle()));
    }

    @DeleteMapping(value = "/users/{id}/taskList")
    public ResponseEntity<TaskListDTO> delete(@PathVariable("id") Long userId, @RequestParam("title") String taskListTitle) throws ValidationError {
        DeleteTaskListRequest request = new DeleteTaskListRequest(userId, taskListTitle);
        DeleteTaskListResponse response = deleteTaskListService.delete(request);
        if (!response.getErrors().isEmpty()) {
            throw new ValidationError(response.getErrors());
        }
        TaskListDTO taskListDTO = new TaskListDTO(response.getTaskListId(), response.getTaskListTitle());
        return new ResponseEntity<>(taskListDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}/taskLists")
    public List<TaskListDTO> getAllTaskLists(@PathVariable("id") Long userId) throws ValidationError {

        GetTaskListRequest request = new GetTaskListRequest(userId);
        GetTaskListResponse response = getTaskListsService.getAllTaskLists(request);
        if (!response.getErrors().isEmpty()) {
            throw new ValidationError(response.getErrors());
        }
        List<TaskListDTO> list = new ArrayList<>();
        for (TaskList taskList : response.getTaskList()) {
            list.add(new TaskListDTO(taskList.getId(), taskList.getTaskListTitle()));
        }
        return list;
    }


}
