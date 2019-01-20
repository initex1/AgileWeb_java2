package lv.initex.console.services.taskLists.getTaskLists.validation;

import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.getTaskLists.GetTaskListRequest;
import lv.initex.console.services.taskLists.getTaskLists.validation.rules.GetTaskListEmptyRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GetTaskListValidatorImplTest {

    @Mock
    private GetTaskListEmptyRule getTaskListEmptyRule;

    @InjectMocks
    GetTaskListValidatorImpl validator;

    @Test
    public void shouldReturnErrorList() {
        User user = new User();
        GetTaskListRequest request = new GetTaskListRequest(user);
        Mockito.when(getTaskListEmptyRule.execute(user))
                .thenReturn(Optional.of(new TaskListError("User", "No such user")));

        List<TaskListError> errors = validator.validate(request);

        assertTrue(!errors.isEmpty());
        assertEquals(errors.get(0).getField(), "User");
        assertEquals(errors.get(0).getDescription(), "No such user");
    }

    @Test
    public void shouldNotReturnErrorList() {
        User user = new User();
        GetTaskListRequest request = new GetTaskListRequest(user);
        Mockito.when(getTaskListEmptyRule.execute(user))
                .thenReturn(Optional.empty());

        List<TaskListError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());
    }

}