package lv.initex.console.services.tasks.addTask.validation.rules;

import lv.initex.console.database.TaskRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.services.TaskListError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)
public class AddDuplicateTaskTitleRuleTest {

    @Mock
    TaskRepository repository;

    @InjectMocks
    AddDuplicateTaskTitleRule rule;

    @Test
    public void shouldReturnErrorIfTaskAlreadyExistInList() {
        Task task = new Task("homework1");
        Mockito.when(repository.findTaskByTitle("homework1"))
                .thenReturn(Optional.of(task));

        Optional<TaskListError> error = rule.execute("homework1");

        assertEquals(error.isPresent(), true);
        assertEquals(error.get().getField(), "title");
        assertEquals(error.get().getDescription(), "Duplicate task exists");

        verify(repository).findTaskByTitle("homework1");
    }

    @Test
    public void shouldReturnNoErrorIfTaskNotExistInList() {
        Mockito.when(repository.findTaskByTitle("homework1"))
                .thenReturn(Optional.empty());

        Optional<TaskListError> error = rule.execute("homework1");

        assertEquals(error.isPresent(), false);
    }

    @Test
    public void shouldReturnNoErrorIfTaskTitleIsNull() {
        Optional<TaskListError> error = rule.execute(null);

        assertEquals(error.isPresent(), false);

        Mockito.verifyZeroInteractions(repository);
    }

}