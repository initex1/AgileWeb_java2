package lv.initex.console.services.taskLists.getTaskLists.validation.rules;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
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

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GetTaskListEmptyRuleTest {

    private User user;

    private TaskList taskList;

    @Mock
    private TaskListRepository database;

    @InjectMocks
    private GetTaskListEmptyRule rule;

    @Before
    public void init() {
        user = new User();
        taskList = new TaskList();
    }

    @Test
    public void shouldReturnErrorList() {
        Optional<TaskListError> errors = rule.execute(user);

        assertTrue(errors.isPresent());
    }

    @Test
    public void shouldNotReturnErrorList() {
        Mockito.when(database.getAllTasks(user))
                .thenReturn(Arrays.asList(taskList));

        Optional<TaskListError> errors = rule.execute(user);

        assertFalse(errors.isPresent());

    }

}