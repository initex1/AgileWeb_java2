package lv.initex.console.services.taskLists.getTaskLists.validation.rules;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
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

    @Mock
    private TaskListRepository database;

    @InjectMocks
    GetTaskListEmptyRule rule;

    @Test
    public void shouldReturnErrorList() {
        User user = new User();
        Optional<TaskListError> errors = rule.execute(user);

        assertTrue(errors.isPresent());

    }

    @Test
    public void shouldNotReturnErrorList() {
        User user = new User();
        TaskList taskList=new TaskList();
        Mockito.when(database.getAllTasks(user))
                .thenReturn(Arrays.asList(taskList));


        Optional<TaskListError> errors = rule.execute(user);

        assertTrue(!errors.isPresent());

    }

}