package lv.initex.console.services.taskListItems.getTaskListItems;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.getTaskListItems.validator.GetTaskListItemsValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetTaskListItemsServiceTest {

    @Mock
    private TaskListItemRepository database;

    @Mock
    private GetTaskListItemsValidator validator;

    @InjectMocks
    GetTaskListItemsService service;

    @Test
    public void shouldReturnTaskListItems() {
        TaskList taskList = new TaskList();
        User user = new User();
        GetTaskListItemsRequest request = new GetTaskListItemsRequest(user, taskList);
        Mockito.when(database.getAllTaskListItems(taskList))
                .thenReturn(Arrays.asList(new TaskListItem()));
        GetTaskListItemsResponse response = service.getAllTaskListItems(request);

        assertTrue(!response.getTaskListItems().isEmpty());
        assertTrue(response.getErrors().isEmpty());
    }

    @Test
    public void shouldReturnErrors() {
        TaskList taskList = new TaskList();
        User user = new User();
        GetTaskListItemsRequest request = new GetTaskListItemsRequest(user, taskList);
        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "yyy")));

        GetTaskListItemsResponse response = service.getAllTaskListItems(request);
        assertTrue(response.getTaskListItems().isEmpty());
        assertTrue(!response.getErrors().isEmpty());
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce() {
        TaskList taskList = new TaskList();
        User user = new User();
        GetTaskListItemsRequest request = new GetTaskListItemsRequest(user, taskList);
        Mockito.when(database.getAllTaskListItems(taskList))
                .thenReturn(Arrays.asList(new TaskListItem()));
        GetTaskListItemsResponse response = service.getAllTaskListItems(request);

        verify(database, times(1)).getAllTaskListItems(anyObject());
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        TaskList taskList = new TaskList();
        User user = new User();
        GetTaskListItemsRequest request = new GetTaskListItemsRequest(user, taskList);
        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "yyy")));
        GetTaskListItemsResponse response = service.getAllTaskListItems(request);

        verify(validator, times(1)).validate(anyObject());
    }
}