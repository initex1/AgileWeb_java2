package lv.initex.console.services.taskListItems.addTaskListItem.validate;

import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.addTaskListItem.AddTaskListItemRequest;
import lv.initex.console.services.taskListItems.addTaskListItem.validate.rules.AddDuplicateTaskListItemRule;
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
public class AddTaskListItemValidatorImplTest {

    private AddTaskListItemRequest request;

    @Mock
    private AddDuplicateTaskListItemRule addDuplicateTaskListItemRule;

    @InjectMocks
    private AddTaskListItemValidatorImpl validator;

    @Before
    public void init() {
        request = new AddTaskListItemRequest(new TaskList(), new Task());
    }

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        Mockito.when(addDuplicateTaskListItemRule.execute(request.getTaskList(), request.getTask()))
                .thenReturn(Optional.of(new TaskListError("TaskListItem", "duplicate listItem")));

        List<TaskListError> error = validator.validate(request);

        assertFalse(error.isEmpty());
    }

    @Test
    public void shouldNotReturnAnyErrors() {
        Mockito.when(addDuplicateTaskListItemRule.execute(request.getTaskList(), request.getTask()))
                .thenReturn(Optional.empty());

        List<TaskListError> error = validator.validate(request);

        assertTrue(error.isEmpty());
    }
}