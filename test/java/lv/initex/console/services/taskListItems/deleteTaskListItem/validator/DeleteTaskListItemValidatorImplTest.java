package lv.initex.console.services.taskListItems.deleteTaskListItem.validator;

import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.deleteTaskListItem.DeleteTaskListItemRequest;
import lv.initex.console.services.taskListItems.deleteTaskListItem.validator.rules.DeleteTaskListItemNotFoundRule;
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

    @Mock
    DeleteTaskListItemNotFoundRule deleteTaskListItemNotFoundRule;

    @InjectMocks
    DeleteTaskListItemValidatorImpl validator;

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        TaskList taskList = new TaskList();
        Task task = new Task();
        DeleteTaskListItemRequest request=new DeleteTaskListItemRequest(taskList, task);

        Mockito.when(deleteTaskListItemNotFoundRule.execute(taskList,task))
                .thenReturn(Optional.of(new TaskListError("TaskListItem", "No such taskListItem!")));

        List<TaskListError> error = validator.validate(request);

        assertTrue(!error.isEmpty());
    }

    @Test
    public void shouldNotReturnAnyErrors() {
        TaskList taskList = new TaskList();
        Task task = new Task();
        DeleteTaskListItemRequest request=new DeleteTaskListItemRequest(taskList, task);

        Mockito.when(deleteTaskListItemNotFoundRule.execute(taskList,task))
                .thenReturn(Optional.empty());

        List<TaskListError> error = validator.validate(request);

        assertTrue(error.isEmpty());
    }

}