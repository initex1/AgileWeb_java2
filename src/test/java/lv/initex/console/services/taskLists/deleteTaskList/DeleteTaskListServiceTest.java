package lv.initex.console.services.taskLists.deleteTaskList;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.deleteTaskList.validation.DeleteTaskListValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTaskListServiceTest {

    private User user;

    private TaskList taskList;

    private DeleteTaskListRequest request;

    @Mock
    private TaskListRepository database;

    @Mock
    private DeleteTaskListValidator validator;

    @InjectMocks
    private DeleteTaskListService service;

    @Before
    public void init() {
        user = new User();
        taskList = new TaskList();
        request = new DeleteTaskListRequest(user, "xxx");
    }

    @Test
    public void shouldReturnResponseWithErrorListAndNoTaskListId() {
        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("title", "empty")));

        DeleteTaskListResponse response = service.delete(request);

        assertNull(response.getTaskListId());
        assertEquals(response.getErrors().size(), 1);
    }

    @Test
    public void shouldReturnResponseWithTaskListIdAndNoErrorsList() {
        taskList.setId(new Long(1));

        Mockito.when(database.findByUserAndTitle(user, "xxx")).thenReturn(Optional.of(taskList));

        DeleteTaskListResponse response = service.delete(request);

        assertEquals(response.getTaskListId(), new Long(1));
        assertNull(response.getErrors());
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        taskList.setId(new Long(1));

        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("title", "empty")));

        DeleteTaskListResponse response = service.delete(request);

        verify(validator).validate(request);
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce() {
        taskList.setId(new Long(1));

        Mockito.when(database.findByUserAndTitle(user, "xxx")).thenReturn(Optional.of(taskList));

        DeleteTaskListResponse response = service.delete(request);

        verify(database).findByUserAndTitle(user, "xxx");
    }
}