package lv.initex.console.services.taskListItems.getTaskListItems;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.getTaskListItems.validator.GetTaskListItemsValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetTaskListItemsServiceTest {

    private TaskList taskList;

    private User user;

    private GetTaskListItemsRequest request;

    @Mock
    private TaskListItemRepository database;

    @Mock
    private GetTaskListItemsValidator validator;

    @InjectMocks
    private GetTaskListItemsService service;

    @Before
    public void init() {
        taskList = new TaskList();
        user = new User();
        request = new GetTaskListItemsRequest(user, taskList);
    }

    @Test
    public void shouldReturnTaskListItems() {
        Mockito.when(database.getAllByTaskList(taskList))
                .thenReturn(Arrays.asList(new TaskListItem()));

        GetTaskListItemsResponse response = service.getAllTaskListItems(request);

        assertFalse(response.getTaskListItems().isEmpty());
        assertTrue(response.getErrors().isEmpty());
    }

    @Test
    public void shouldReturnErrors() {
        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "yyy")));

        GetTaskListItemsResponse response = service.getAllTaskListItems(request);

        assertTrue(response.getTaskListItems().isEmpty());
        assertFalse(response.getErrors().isEmpty());
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce() {
        Mockito.when(database.getAllByTaskList(taskList))
                .thenReturn(Arrays.asList(new TaskListItem()));

        GetTaskListItemsResponse response = service.getAllTaskListItems(request);

        verify(database).getAllByTaskList(taskList);
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "yyy")));

        GetTaskListItemsResponse response = service.getAllTaskListItems(request);

        verify(validator).validate(request);
    }
}