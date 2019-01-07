package validation.rules;

import lv.database.TaskRepository;
import lv.domain.Task;
import lv.services.TaskListError;
import lv.services.tasks.addTask.validation.rules.AddDuplicateTaskTitleRule;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class DuplicateTaskTitleRuleTest {
    private TaskRepository repository;
    private AddDuplicateTaskTitleRule rule;

    @Before
    public void init() {
        repository = Mockito.mock(TaskRepository.class);
        rule = new AddDuplicateTaskTitleRule(repository);
    }

    @Test
    public void shouldReturnErrorIfProductAlreadyExistInList() {
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
    public void shouldReturnNoErrorIfProductNotExistInList() {
        Mockito.when(repository.findTaskByTitle("homework1"))
                .thenReturn(Optional.empty());

        Optional<TaskListError> error = rule.execute("homework1");

        assertEquals(error.isPresent(), false);
    }

    @Test
    public void shouldReturnNoErrorIfProductTitleIsNull() {
        Optional<TaskListError> error = rule.execute(null);

        assertEquals(error.isPresent(), false);

        Mockito.verifyZeroInteractions(repository);
    }

}