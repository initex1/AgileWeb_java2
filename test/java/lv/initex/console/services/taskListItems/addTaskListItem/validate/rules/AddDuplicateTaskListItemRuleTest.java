package lv.initex.console.services.taskListItems.addTaskListItem.validate.rules;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AddDuplicateTaskListItemRuleTest {

    @Mock
    TaskListItemRepository database;

    @InjectMocks
    AddDuplicateTaskListItemRule rule;

    @Test
    public void shouldReturnErrorIfTaskListItemAlreadyExistInList() {
        TaskListItem item = new TaskListItem();
        TaskList taskList = new TaskList();
        Task task = new Task();

        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.of(item));

        Optional<TaskListError> error = rule.execute(taskList, task);

        assertTrue(error.isPresent());
    }

    @Test
    public void shouldNotReturnErrorIfTaskListItemNotExistInList() {
        TaskList taskList = new TaskList();
        Task task = new Task();

        Mockito.when(database.findByTaskListAndTask(taskList, task))
                .thenReturn(Optional.empty());

        Optional<TaskListError> error = rule.execute(taskList, task);

        assertTrue(!error.isPresent());
    }


}
