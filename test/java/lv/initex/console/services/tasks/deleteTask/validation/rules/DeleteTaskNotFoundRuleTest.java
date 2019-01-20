package lv.initex.console.services.tasks.deleteTask.validation.rules;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.NotNull;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTaskNotFoundRuleTest {

    @Mock
    private TaskRepository database;

    @InjectMocks
    private DeleteTaskNotFoundRule rule;

    @Test
    public void shouldReturnErrorIfTaskNotFound() {
        Mockito.when(database.findTaskByTitle("xxx")).thenReturn(Optional.empty());

        Optional<TaskListError> error = rule.execute("xxx");

        assertEquals(error.isPresent(), true);
        assertEquals(error.get().getField(), "title");
        assertEquals(error.get().getDescription(), "Entered task title not found!");
    }

    @Test
    public void shouldNotReturnErrorIfTaskFound() {
        Task task = new Task("xxx");
        Mockito.when(database.findTaskByTitle("xxx")).thenReturn(Optional.of(task));

        Optional<TaskListError> error = rule.execute("xxx");

        assertEquals(error.isPresent(), false);
    }
}