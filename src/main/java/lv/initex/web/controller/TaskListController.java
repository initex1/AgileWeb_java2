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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TaskListController {

    @Autowired
    private AddTaskListService addTaskListService;

    @Autowired
    private DeleteTaskListService deleteTaskListService;

    @Autowired
    private GetTaskListsService getTaskListsService;

    @ResponseBody
    @PostMapping(value = "/users/{id}/addTaskList")
    public ResponseEntity<TaskListDTO> add(@PathVariable("id") Long userId, @RequestParam("title") String taskListTitle) {

        AddTaskListRequest request = new AddTaskListRequest(userId, taskListTitle);
        AddTaskListResponse response = addTaskListService.add(request);
        return ResponseEntity.ok(new TaskListDTO(response.getTaskListId()));
    }

    // @ResponseBody
    @DeleteMapping(value = "/users/{id}/deleteTaskList")
    public TaskListDTO delete(@PathVariable("id") Long userId,@RequestParam("title") String taskListTitle) {
        DeleteTaskListRequest request = new DeleteTaskListRequest(userId, taskListTitle);
        DeleteTaskListResponse response = deleteTaskListService.delete(request);
        if (!response.getErrors().isEmpty()) {
            return new TaskListDTO(response.getErrors());
        }
        return new TaskListDTO(response.getTaskListId());
    }


    @GetMapping(value = "/users/{id}/taskLists")
    public List<TaskListDTO> getAllTaskLists(@PathVariable("id") Long userId) {

        GetTaskListRequest request = new GetTaskListRequest(userId);
        GetTaskListResponse response = getTaskListsService.getAllTaskLists(request);
        if (!response.getErrors().isEmpty()) {
            return Arrays.asList(new TaskListDTO(response.getErrors()));
        }
        List<TaskListDTO> list = new ArrayList<>();
        for (TaskList taskList : response.getTaskList()) {
            list.add(new TaskListDTO(taskList.getId(), taskList.getUser().getId(), taskList.getTaskListTitle()));
        }
        return list;
    }
}
