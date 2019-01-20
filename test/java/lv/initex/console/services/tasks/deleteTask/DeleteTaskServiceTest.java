package lv.initex.console.services.tasks.deleteTask;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.deleteTask.validation.DeleteTaskValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTaskServiceTest {

    @Mock
    private TaskRepository database;

    @Mock
    private DeleteTaskValidator validator;

    @InjectMocks
    private DeleteTaskService service ;

    @Test
    public void shouldReturnResponseWithTaskIdAndNoErrorsList() {
        Task task = new Task("xxx");
        task.setId(new Long("1"));
        DeleteTaskRequest request = new DeleteTaskRequest(task.getTaskTitle());

        Mockito.when(database.findTaskByTitle(task.getTaskTitle())).thenReturn(Optional.of(task));

        DeleteTaskResponse response = service.delete(request);

        assertEquals(new Long("1"), response.getTaskId());
        assertEquals(null, response.getErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsListAndNoTaskId() {

        DeleteTaskRequest request = new DeleteTaskRequest("xxx");
        List<TaskListError> errors = Arrays.asList(new TaskListError("Task Field", "No such Task"));

        Mockito.when(validator.validate(request)).thenReturn(errors);

        DeleteTaskResponse response = service.delete(request);

        assertEquals(null, response.getTaskId());
        assertEquals(1, response.getErrors().size());
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce() {
        Task task = new Task("xxx");
        task.setId(new Long("1"));
        Mockito.when(database.findTaskByTitle(task.getTaskTitle())).thenReturn(Optional.of(task));
        Mockito.when(database.deleteTask(task)).thenReturn(true);

        DeleteTaskRequest request = new DeleteTaskRequest(task.getTaskTitle());
        DeleteTaskResponse response = service.delete(request);
        verify(database, times(1)).findTaskByTitle(task.getTaskTitle());
        verify(database, times(1)).deleteTask(task);
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        DeleteTaskRequest request = new DeleteTaskRequest("xxx");
        Mockito.when(validator.validate(request)).thenReturn(Arrays.asList(new TaskListError("Task Field", "No such Task")));

        DeleteTaskResponse response = service.delete(request);
        verify(validator, times(1)).validate(request);
    }

}
