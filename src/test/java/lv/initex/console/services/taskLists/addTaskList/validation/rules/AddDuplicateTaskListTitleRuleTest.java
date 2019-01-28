package lv.initex.console.services.taskLists.addTaskList.validation.rules;

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
public class AddDuplicateTaskListTitleRuleTest {

    @Mock
    TaskListRepository database;

    @InjectMocks
    AddDuplicateTaskListTitleRule rule;

    @Test
    public void shouldReturnErrorIfTaskListAlreadyExistInList() {
        User user = new User();
        TaskList taskList = new TaskList();
        Mockito.when(database.findByUserIdAndTitle(new Long(1), "xxx"))
                .thenReturn(Optional.of(taskList));

        Optional<TaskListError> error = rule.execute(new Long(1), "xxx");

        assertTrue(error.isPresent());
    }

    @Test
    public void shouldNotReturnErrorIfTaskListNotInList(){
        User user = new User();

        Mockito.when(database.findByUserIdAndTitle(new Long(1), "xxx"))
                .thenReturn(Optional.empty());

        Optional<TaskListError> error = rule.execute(new Long(1), "xxx");
        assertTrue(!error.isPresent());
    }

}