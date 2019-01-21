package lv.initex.console.services.tasks.addTask;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.addTask.validation.AddTaskValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddTaskServiceTest {

    private AddTaskRequest request;

    @Mock
    private TaskRepository database;

    @Mock
    private AddTaskValidator validator;


    @InjectMocks
    private AddTaskService service;

    @Before
    public void init() {
        request = new AddTaskRequest("xxx");
    }

    @Test
    public void shouldReturnResponseWithErrorsListAndNoTaskId() {
        List<TaskListError> errors = Arrays.asList(new TaskListError("Task Field", "No such Task"));

        Mockito.when(validator.validate(request)).thenReturn(errors);

        AddTaskResponse response = service.add(request);

        assertNull(response.getTaskId());
        assertEquals(response.getErrors().get(0).getDescription(), "No such Task");
        assertFalse(response.isSuccess());
    }

    @Test
    public void verifyThatDatabaseAddMethodWasCalledOnce() {

        AddTaskResponse response = service.add(request);
        verify(database).addTask(any(Task.class));
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {

        AddTaskResponse response = service.add(request);
        verify(validator).validate(request);
    }
}