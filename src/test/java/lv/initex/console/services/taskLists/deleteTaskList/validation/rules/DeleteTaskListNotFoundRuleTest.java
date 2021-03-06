package lv.initex.console.services.taskLists.deleteTaskList.validation.rules;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
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

 //   private User user;

    @Mock
    private TaskListRepository database;

    @InjectMocks
    private DeleteTaskListNotFoundRule rule;

//    @Before
//    public void init() {
//        user = new User();
//    }

    @Test
    public void shouldReturnErrorIfTaskListNotFound() {
        Mockito.when(database.findByUserIdAndTitle(new Long(1), "xxx"))
                .thenReturn(Optional.empty());

        Optional<TaskListError> errors = rule.execute(new Long(1), "xxx");

        assertTrue(errors.isPresent());
    }

    @Test
    public void shouldNotReturnErrorIfTaskListFound() {
        TaskList taskList = new TaskList();
        Mockito.when(database.findByUserIdAndTitle(new Long(1), "xxx"))
                .thenReturn(Optional.of(taskList));

        Optional<TaskListError> errors = rule.execute(new Long(1), "xxx");

        assertFalse(errors.isPresent());

    }
}