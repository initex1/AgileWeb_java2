package lv.initex.console.services.tasks.getTask.validation.rules;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GetTasksEmptyRuleTest {

    @Mock
    private TaskRepository database;

    @InjectMocks
    GetTasksEmptyRule rule;

    @Test
    public void shouldReturnErrorNoTasks() {
        Optional<TaskListError> error = rule.execute();

        assertEquals(true, error.isPresent());
        assertEquals("User", error.get().getField());
        assertEquals("User don't have any task", error.get().getDescription());
    }

    @Test
    public void shouldRNotReturnErrorNoTasks() {
        Mockito.when(database.findAll()).thenReturn(Arrays.asList(new Task("xxx")));
        Optional<TaskListError> error = rule.execute();
        assertEquals(false, error.isPresent());
    }
}