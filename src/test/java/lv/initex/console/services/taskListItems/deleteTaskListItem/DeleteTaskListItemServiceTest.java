package lv.initex.console.services.taskListItems.deleteTaskListItem;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.deleteTaskListItem.validator.DeleteTaskListItemValidator;
import org.junit.Before;
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

    private Task task;

    private TaskList taskList;

    private DeleteTaskListItemRequest request;

    private TaskListItem item;

    @Mock
    private TaskListItemRepository database;

    @Mock
    private DeleteTaskListItemValidator validator;

    @InjectMocks
    private DeleteTaskListItemService service;

    @Before
    public void init() {
        taskList = new TaskList();
        task = new Task();
        item = new TaskListItem();
        request = new DeleteTaskListItemRequest(taskList, task);
    }

    @Test
    public void shouldReturnResponseWithErrorListAndNoTaskListItemId() {
        List<TaskListError> errors = Arrays.asList(new TaskListError("TaskListItem", "No such taskListItem!"));
        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        DeleteTaskListItemResponse response = service.delete(request);

        assertNull(response.getTaskListItemId());
        assertEquals(response.getErrors().size(), 1);
    }

    @Test
    public void shouldReturnResponseWithTaskListItemIdAndNoErrorsList() {
        item.setId(new Long(1));

        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.of(item));

        DeleteTaskListItemResponse response = service.delete(request);

        assertEquals(new Long(1), response.getTaskListItemId());
        assertNull(response.getErrors());
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        List<TaskListError> errors = Arrays.asList(new TaskListError("TaskListItem", "No such taskListItem!"));
        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        DeleteTaskListItemResponse response = service.delete(request);
        verify(validator).validate(request);
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce() {
        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.of(item));

        Mockito.when(database.deleteTaskListItem(item)).thenReturn(true);

        DeleteTaskListItemResponse response = service.delete(request);

        verify(database).findByTaskListAndTask(taskList, task);
        verify(database).deleteTaskListItem(item);
    }


}