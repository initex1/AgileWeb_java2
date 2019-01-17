package lv.console.services.tasks.deleteTask;

import lv.console.database.TaskRepository;
import lv.console.domain.Task;
import lv.console.domain.TaskList;
import lv.console.services.TaskListError;
import lv.console.services.tasks.deleteTask.validation.DeleteTaskValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class DeleteTaskServiceTest {

    @Mock
    private TaskRepository database;

    @Mock
    private DeleteTaskValidator validator;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void delete() {
        List<TaskListError> errors=new ArrayList<>();
        DeleteTaskRequest request=new DeleteTaskRequest("xxx");
        Task task=new Task("xxx");
       // Mockito.when(validator.validate(request)).thenReturn(errors.isEmpty());
       // Mockito.when(database.findTaskByTitle(request.getTaskTitle())).thenReturn(Optional.of(task));
        //database.deleteTask(task);



    }
}