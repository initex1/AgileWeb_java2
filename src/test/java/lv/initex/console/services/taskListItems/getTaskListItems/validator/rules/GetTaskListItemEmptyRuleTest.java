package lv.initex.console.services.taskListItems.getTaskListItems.validator.rules;

import lv.initex.console.database.TaskListItemRepository;
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

import java.util.Arrays;
import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GetTaskListItemEmptyRuleTest {

    private TaskList taskList;

    @Mock
    private TaskListItemRepository database;

    @InjectMocks
    private GetTaskListItemEmptyRule rule;

    @Before
    public void init(){
        taskList=new TaskList();
    }

    @Test
    public void shouldReturnErrorNoTasks() {
        Optional<TaskListError> error = rule.execute(taskList);

        assertTrue(error.isPresent());
        assertEquals("List", error.get().getField());
        assertEquals("TaskListItem list is empty!", error.get().getDescription());
    }

    @Test
    public void shouldNotReturnError() {
        Mockito.when(database.getAllByTaskList(taskList))
                .thenReturn(Arrays.asList(new TaskListItem()));

        Optional<TaskListError> error = rule.execute(taskList);

        assertFalse( error.isPresent());
    }
}