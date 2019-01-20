package lv.initex.console.services.taskListItems.addTaskListItem.validate;

import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.addTaskListItem.AddTaskListItemRequest;
import lv.initex.console.services.taskListItems.addTaskListItem.validate.rules.AddDuplicateTaskListItemRule;
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

    @Mock
    AddDuplicateTaskListItemRule addDuplicateTaskListItemRule;

    @InjectMocks
    AddTaskListItemValidatorImpl validator;

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        AddTaskListItemRequest request = new AddTaskListItemRequest(new TaskList(), new Task());
        Mockito.when(addDuplicateTaskListItemRule.execute(request.getTaskList(), request.getTask()))
                .thenReturn(Optional.of(new TaskListError("TaskListItem", "duplicate listItem")));

        List<TaskListError> error = validator.validate(request);

        assertTrue(!error.isEmpty());
    }

    @Test
    public void shouldNotReturnAnyErrors() {
        AddTaskListItemRequest request = new AddTaskListItemRequest(new TaskList(), new Task());
        Mockito.when(addDuplicateTaskListItemRule.execute(request.getTaskList(), request.getTask()))
                .thenReturn(Optional.empty());

        List<TaskListError> error = validator.validate(request);

        assertTrue(error.isEmpty());
    }
}