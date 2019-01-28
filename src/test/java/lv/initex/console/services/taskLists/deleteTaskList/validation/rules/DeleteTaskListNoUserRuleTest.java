package lv.initex.console.services.taskLists.deleteTaskList.validation.rules;

import lv.initex.console.database.UserRepository;
import lv.initex.console.domain.User;
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
public class DeleteTaskListNoUserRuleTest {

    private User user;

    @Mock
    private UserRepository database;

    @InjectMocks
    private DeleteTaskListNoUserRule rule;

    @Before
    public void init() {
        user = new User();
        user.setId(new Long(1));
    }

    @Test
    public void shouldReturnErrorNoUser() {
        Mockito.when(database.findById(user.getId()))
                .thenReturn(Optional.empty());

        Optional<TaskListError> errors = rule.execute(user.getId());

        assertTrue(errors.isPresent());
    }

    @Test
    public void shouldNotReturnError() {
        Mockito.when(database.findById(user.getId()))
                .thenReturn(Optional.of(user));

        Optional<TaskListError> errors = rule.execute(user.getId());

        assertFalse(errors.isPresent());
    }
}