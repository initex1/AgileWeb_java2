package lv.initex.web.controller;


import lv.initex.console.services.taskLists.addTaskList.AddTaskListService;
import lv.initex.console.services.taskLists.deleteTaskList.DeleteTaskListService;
import lv.initex.console.services.taskLists.getTaskLists.GetTaskListsService;
import lv.initex.web.dtos.TaskListDTO;
import lv.initex.web.dtos.TaskListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskListController {

    @Autowired
    private AddTaskListService addTaskListService;

    @Autowired
    private DeleteTaskListService deleteTaskListService;

    @Autowired
    private GetTaskListsService getTaskListsService;


    @PostMapping(value = "/users/{id}/taskLists/{title}")
    public ResponseEntity<TaskListResponseDTO> add(@PathVariable("id") Long userId, @PathVariable("title") String taskListTitle) throws ValidationError {

        TaskListDTO request = new TaskListDTO(userId, taskListTitle);
        TaskListResponseDTO response = addTaskListService.add(request);
        if (!response.getErrors().isEmpty()) {
            throw new ValidationError(response.getErrors());
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/users/{id}/taskLists/{title}")
    public ResponseEntity<TaskListResponseDTO> delete(@PathVariable("id") Long userId, @PathVariable("title") String taskListTitle) throws ValidationError {
        TaskListDTO request = new TaskListDTO(userId, taskListTitle);
        TaskListResponseDTO response = deleteTaskListService.delete(request);
        if (!response.getErrors().isEmpty()) {
            throw new ValidationError(response.getErrors());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}/taskLists/")
    public List<TaskListResponseDTO> getAllTaskLists(@PathVariable("id") Long userId) throws ValidationError {

        TaskListDTO request = new TaskListDTO(userId);
        List<TaskListResponseDTO> response = getTaskListsService.getAllTaskLists(request);
        if (response.get(0).getErrors() != null) {
            throw new ValidationError(response.get(0).getErrors());
        }
        return response;
    }


}
