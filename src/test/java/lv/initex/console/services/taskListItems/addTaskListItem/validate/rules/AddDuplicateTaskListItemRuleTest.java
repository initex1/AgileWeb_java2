package lv.initex.console.services.taskListItems.addTaskListItem.validate.rules;

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

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AddDuplicateTaskListItemRuleTest {

    private TaskList taskList;

    private Task task;

    @Mock
    private TaskListItemRepository database;

    @InjectMocks
    private AddDuplicateTaskListItemRule rule;

    @Before
    public void init() {
        taskList = new TaskList();
        task = new Task();
    }

    @Test
    public void shouldReturnErrorIfTaskListItemAlreadyExistInList() {
        TaskListItem item = new TaskListItem();

        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.of(item));

        Optional<TaskListError> error = rule.execute(taskList, task);

        assertTrue(error.isPresent());
    }

    @Test
    public void shouldNotReturnErrorIfTaskListItemNotExistInList() {
        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.empty());

        Optional<TaskListError> error = rule.execute(taskList, task);

        assertFalse(error.isPresent());
    }


}
