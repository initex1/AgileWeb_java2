package lv.initex.console.services.taskListItems.deleteTaskListItem.validator.rules;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTaskListItemNotFoundRuleTest {

    @Mock
    TaskListItemRepository database;

    @InjectMocks
    DeleteTaskListItemNotFoundRule rule;

    @Test
    public void shouldReturnErrorIfTaskListItemNotFound() {
        TaskList taskList = new TaskList();
        Task task = new Task();

        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.empty());

        Optional<TaskListError> errors = rule.execute(taskList, task);
        assertTrue(errors.isPresent());
    }

    @Test
    public void shouldNotReturnErrorIfTaskListItemFound() {
        TaskListItem item = new TaskListItem();
        TaskList taskList = new TaskList();
        Task task = new Task();

        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.of(item));

        Optional<TaskListError> errors = rule.execute(taskList, task);
        assertTrue(!errors.isPresent());
    }


}