package lv.initex.console.services.taskLists.deleteTaskList;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.deleteTaskList.validation.DeleteTaskListValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTaskListServiceTest {

    @Mock
    private TaskListRepository database;

    @Mock
    private DeleteTaskListValidator validator;

    @InjectMocks
    DeleteTaskListService service;

    @Test
    public void shouldReturnResponseWithErrorListAndNoTaskListId() {
        User user = new User();
        DeleteTaskListRequest request = new DeleteTaskListRequest(user, "xxx");

        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("title", "empty")));

        DeleteTaskListResponse response = service.delete(request);

        assertEquals(response.getTaskListId(), null);
        assertEquals(response.getErrors().size(), 1);
    }

    @Test
    public void shouldReturnResponseWithTaskListIdAndNoErrorsList() {
        User user = new User();
        TaskList taskList = new TaskList();
        taskList.setId(new Long(1));

        DeleteTaskListRequest request = new DeleteTaskListRequest(user, "xxx");

        Mockito.when(database.findByUserAndTitle(user, "xxx")).thenReturn(Optional.of(taskList));

        DeleteTaskListResponse response = service.delete(request);

        assertEquals(response.getTaskListId(), new Long(1));
        assertEquals(response.getErrors(), null);
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        User user = new User();
        TaskList taskList = new TaskList();
        taskList.setId(new Long(1));
        DeleteTaskListRequest request = new DeleteTaskListRequest(user, "xxx");

        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("title", "empty")));

        DeleteTaskListResponse response = service.delete(request);

        verify(validator, times(1)).validate(request);
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce(){
        User user = new User();
        TaskList taskList = new TaskList();
        taskList.setId(new Long(1));
        DeleteTaskListRequest request = new DeleteTaskListRequest(user, "xxx");

        Mockito.when(database.findByUserAndTitle(user, "xxx")).thenReturn(Optional.of(taskList));

        Mockito.when(database.deleteTaskList(taskList)).thenReturn(true);

        DeleteTaskListResponse response = service.delete(request);

        verify(database, times(1)).findByUserAndTitle(anyObject(), anyObject());
        verify(database, times(1)).deleteTaskList(anyObject());

    }
}