package lv.initex.console.services.taskLists.deleteTaskList.validation.rules;

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

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTaskListNotFoundRuleTest {

    @Mock
    TaskListRepository database;

    @InjectMocks
    DeleteTaskListNotFoundRule rule;

    @Test
    public void shouldReturnErrorIfTaskListNotFound() {
        User user = new User();
        Mockito.when(database.findByUserAndTitle(user, "xxx"))
                .thenReturn(Optional.empty());
        Optional<TaskListError> errors = rule.execute(user, "xxx");
        assertTrue(errors.isPresent());
    }

    @Test
    public void shouldNotReturnErrorIfTaskListFound() {
        User user = new User();
        TaskList taskList = new TaskList();
        Mockito.when(database.findByUserAndTitle(user, "xxx"))
                .thenReturn(Optional.of(taskList));
        Optional<TaskListError> errors = rule.execute(user, "xxx");
        assertTrue(!errors.isPresent());

    }
}