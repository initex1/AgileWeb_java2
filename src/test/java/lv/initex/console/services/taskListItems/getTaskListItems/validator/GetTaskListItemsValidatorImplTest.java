package lv.initex.console.services.taskListItems.getTaskListItems.validator;

import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.getTaskListItems.GetTaskListItemsRequest;
import lv.initex.console.services.taskListItems.getTaskListItems.validator.rules.GetTaskListItemEmptyRule;
import org.junit.Before;
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
public class GetTaskListItemsValidatorImplTest {

    private TaskList taskList;

    private User user;

    private GetTaskListItemsRequest request;

    @Mock
    private GetTaskListItemEmptyRule getTaskListItemEmptyRule;

    @InjectMocks
    private GetTaskListItemsValidatorImpl validator;

    @Before
    public void init() {
        taskList = new TaskList();
        user = new User();
        request = new GetTaskListItemsRequest(user, taskList);
    }

    @Test
    public void shouldReturnErrorList() {
        Mockito.when(getTaskListItemEmptyRule.execute(taskList))
                .thenReturn(Optional.of(new TaskListError("xxx", "yyy")));

        List<TaskListError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.get(0).getField(), "xxx");
        assertEquals(errors.get(0).getDescription(), "yyy");
    }

    @Test
    public void shouldNotReturnErrorList() {
        Mockito.when(getTaskListItemEmptyRule.execute(taskList))
                .thenReturn(Optional.empty());

        List<TaskListError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());
    }
}