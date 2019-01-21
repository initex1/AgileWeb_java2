package lv.initex.console.services.taskListItems.deleteTaskListItem.validator;

import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.deleteTaskListItem.DeleteTaskListItemRequest;
import lv.initex.console.services.taskListItems.deleteTaskListItem.validator.rules.DeleteTaskListItemNotFoundRule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTaskListItemValidatorImplTest {

    private TaskList taskList;

    private Task task;

    private DeleteTaskListItemRequest request;

    @Mock
    private DeleteTaskListItemNotFoundRule deleteTaskListItemNotFoundRule;

    @InjectMocks
    private DeleteTaskListItemValidatorImpl validator;

    @Before
    public void init() {
        taskList = new TaskList();
        task = new Task();
        request = new DeleteTaskListItemRequest(taskList, task);
    }

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        Mockito.when(deleteTaskListItemNotFoundRule.execute(taskList, task))
                .thenReturn(Optional.of(new TaskListError("TaskListItem", "No such taskListItem!")));

        List<TaskListError> error = validator.validate(request);

        assertFalse(error.isEmpty());
    }

    @Test
    public void shouldNotReturnAnyErrors() {
        Mockito.when(deleteTaskListItemNotFoundRule.execute(taskList, task))
                .thenReturn(Optional.empty());

        List<TaskListError> error = validator.validate(request);

        assertTrue(error.isEmpty());
    }

}