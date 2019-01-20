package lv.initex.console.services.taskListItems.getTaskListItems.validator.rules;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GetTaskListItemEmptyRuleTest {

    @Mock
    private TaskListItemRepository database;

    @InjectMocks
    GetTaskListItemEmptyRule rule;

    @Test
    public void shouldReturnErrorNoTasks() {
        TaskList taskList=new TaskList();
        Optional<TaskListError> error = rule.execute(taskList);

        assertEquals(true, error.isPresent());
        assertEquals("List", error.get().getField());
        assertEquals("TaskListItem list is empty!", error.get().getDescription());
    }

    @Test
    public void shouldNotReturnError() {

        TaskList taskList=new TaskList();
        Mockito.when(database.getAllTaskListItems(taskList))
                .thenReturn(Arrays.asList(new TaskListItem()));
        Optional<TaskListError> error = rule.execute(taskList);

        assertEquals(false, error.isPresent());
    }
}