package lv.initex.console.services.taskListItems.deleteTaskListItem;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.deleteTaskListItem.validator.DeleteTaskListItemValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTaskListItemServiceTest {


    @Mock
    private TaskListItemRepository database;

    @Mock
    private DeleteTaskListItemValidator validator;

    @InjectMocks
    DeleteTaskListItemService service;


    @Test
    public void shouldReturnResponseWithErrorListAndNoTaskListItemId() {
        TaskList taskList = new TaskList();
        Task task = new Task();
        DeleteTaskListItemRequest request = new DeleteTaskListItemRequest(taskList, task);
        List<TaskListError> errors = Arrays.asList(new TaskListError("TaskListItem", "No such taskListItem!"));
        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        DeleteTaskListItemResponse response = service.delete(request);

        assertEquals(response.getTaskListItemId(), null);
        assertEquals(response.getErrors().size(), 1);
    }

    @Test
    public void shouldReturnResponseWithTaskListItemIdAndNoErrorsList() {
        TaskList taskList = new TaskList();
        Task task = new Task();
        TaskListItem item = new TaskListItem();
        item.setId(new Long(1));
        DeleteTaskListItemRequest request = new DeleteTaskListItemRequest(taskList, task);

        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.of(item));

        DeleteTaskListItemResponse response = service.delete(request);

        assertEquals(new Long(1), response.getTaskListItemId());
        assertEquals(null, response.getErrors());
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        TaskList taskList = new TaskList();
        Task task = new Task();
        DeleteTaskListItemRequest request = new DeleteTaskListItemRequest(taskList, task);
        List<TaskListError> errors = Arrays.asList(new TaskListError("TaskListItem", "No such taskListItem!"));
        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        DeleteTaskListItemResponse response = service.delete(request);
        verify(validator, times(1)).validate(request);
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce(){
        TaskList taskList = new TaskList();
        Task task = new Task();
        TaskListItem item = new TaskListItem();

        DeleteTaskListItemRequest request = new DeleteTaskListItemRequest(taskList, task);

        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.of(item));

        Mockito.when(database.deleteTaskListItem(item)).thenReturn(true);

        DeleteTaskListItemResponse response = service.delete(request);

        verify(database, times(1)).findByTaskListAndTask(anyObject(), anyObject());
        verify(database, times(1)).deleteTaskListItem(anyObject());
    }


}