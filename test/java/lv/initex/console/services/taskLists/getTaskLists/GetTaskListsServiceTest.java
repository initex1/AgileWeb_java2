package lv.initex.console.services.taskLists.getTaskLists;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.getTaskLists.validation.GetTaskListValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetTaskListsServiceTest {

    @Mock
    private TaskListRepository database;

    @Mock
    private GetTaskListValidator validator;

    @InjectMocks
    GetTaskListsService service;

    @Test
    public void shouldReturnTaskList() {
        User user = new User();
        GetTaskListRequest request = new GetTaskListRequest(user);
        Mockito.when(database.getAllTasks(user))
                .thenReturn(Arrays.asList(new TaskList()));

        GetTaskListResponse response = service.getAllTaskLists(request);

        assertTrue(!response.getTaskList().isEmpty());
        assertTrue(response.getErrors().isEmpty());
    }

    @Test
    public void shouldReturnErrors() {
        User user = new User();
        GetTaskListRequest request = new GetTaskListRequest(user);

        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "vvv")));

        GetTaskListResponse response = service.getAllTaskLists(request);

        assertTrue(response.getTaskList().isEmpty());
        assertTrue(!response.getErrors().isEmpty());
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce() {
        User user = new User();
        GetTaskListRequest request = new GetTaskListRequest(user);

        Mockito.when(database.getAllTasks(user))
                .thenReturn(Arrays.asList(new TaskList()));

        GetTaskListResponse response = service.getAllTaskLists(request);
        verify(database, times(1)).getAllTasks(user);
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        User user = new User();
        GetTaskListRequest request = new GetTaskListRequest(user);

        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "vvv")));

        GetTaskListResponse response = service.getAllTaskLists(request);
        verify(validator, times(1)).validate(anyObject());
    }
}