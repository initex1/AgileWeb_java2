package lv.initex.console.services.tasks.addTask;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.addTask.validation.AddTaskValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddTaskServiceTest {

    @Mock
    private TaskRepository database;

    @Mock
    private AddTaskValidator validator;

    @InjectMocks
    AddTaskService service;

    @Test
    public void shouldReturnResponseWithErrorsListAndNoTaskId() {
        AddTaskRequest request = new AddTaskRequest("xxx");
        List<TaskListError> errors = Arrays.asList(new TaskListError("Task Field", "No such Task"));

        Mockito.when(validator.validate(request)).thenReturn(errors);

        AddTaskResponse response = service.add(request);

        assertEquals(response.getTaskId(), null);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.isSuccess(), false);

    }

    @Test
    public void verifyThatDatabaseAddMethodWasCalledOnce() {
        AddTaskRequest request = new AddTaskRequest("xxx");

        AddTaskResponse response = service.add(request);
        verify(database, times(1)).addTask(anyObject());
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        AddTaskRequest request = new AddTaskRequest("xxx");

        AddTaskResponse response = service.add(request);
        verify(validator, times(1)).validate(anyObject());
    }
}