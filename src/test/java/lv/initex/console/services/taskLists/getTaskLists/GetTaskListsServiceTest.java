package lv.initex.console.services.taskLists.getTaskLists;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.getTaskLists.validation.GetTaskListValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetTaskListsServiceTest {

  //  private User user;

    private GetTaskListRequest request;

    @Mock
    private TaskListRepository database;

    @Mock
    private GetTaskListValidator validator;

    @InjectMocks
    private GetTaskListsService service;

    @Before
    public void init() {
  //     user = new User();
        request = new GetTaskListRequest(new Long(1));
    }

    @Test
    public void shouldReturnTaskList() {
        Mockito.when(database.findAllByUser(request.getUserId()))
                .thenReturn(Arrays.asList(new TaskList()));

        GetTaskListResponse response = service.getAllTaskLists(request);

        assertFalse(response.getTaskList().isEmpty());
        assertTrue(response.getErrors().isEmpty());
    }

    @Test
    public void shouldReturnErrors() {
        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "vvv")));

        GetTaskListResponse response = service.getAllTaskLists(request);

        assertTrue(response.getTaskList().isEmpty());
        assertFalse(response.getErrors().isEmpty());
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce() {
        Mockito.when(database.findAllByUser(request.getUserId()))
                .thenReturn(Arrays.asList(new TaskList()));

        GetTaskListResponse response = service.getAllTaskLists(request);
        verify(database).findAllByUser(request.getUserId());
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "vvv")));

        GetTaskListResponse response = service.getAllTaskLists(request);
        verify(validator).validate(request);
    }
}