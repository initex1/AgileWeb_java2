package lv.initex.console.services.taskListItems.deleteTaskListItem.validator.rules;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import org.junit.Before;
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

    private TaskList taskList;

    private Task task;

    @Mock
    private TaskListItemRepository database;

    @InjectMocks
    private DeleteTaskListItemNotFoundRule rule;

    @Before
    public void init() {
        taskList = new TaskList();
        task = new Task();
    }

    @Test
    public void shouldReturnErrorIfTaskListItemNotFound() {
        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.empty());

        Optional<TaskListError> errors = rule.execute(taskList, task);

        assertTrue(errors.isPresent());
    }

    @Test
    public void shouldNotReturnErrorIfTaskListItemFound() {
        TaskListItem item = new TaskListItem();

        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.of(item));

        Optional<TaskListError> errors = rule.execute(taskList, task);

        assertFalse(errors.isPresent());
    }


}