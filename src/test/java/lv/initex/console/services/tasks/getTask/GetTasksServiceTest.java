package lv.initex.console.services.tasks.getTask;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.getTask.validation.GetTasksValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetTasksServiceTest {

    @Mock
    TaskRepository database;

    @Mock
    GetTasksValidator validator;

    @InjectMocks
    GetTasksService service;

    @Test
    public void shouldReturnResponseWithTaskList() {
        Mockito.when(database.findAll())
                .thenReturn(Arrays.asList(new Task("xxx")));
        GetTasksResponse response = service.getAllTasks();
        assertEquals(true, !response.getTasks().isEmpty());
        assertEquals("xxx", response.getTasks().get(0).getTaskTitle());
    }

    @Test
    public void shouldReturnRespondWithErrors() {
        Mockito.when(validator.validate())
                .thenReturn(Arrays.asList(new TaskListError("xxx", "yyy")));
        GetTasksResponse response = service.getAllTasks();
        assertEquals(true, !response.getErrors().isEmpty());
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce() {
        GetTasksResponse response = service.getAllTasks();
        verify(database, times(1)).findAll();
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        GetTasksResponse response = service.getAllTasks();
        verify(validator, times(1)).validate();
    }

}