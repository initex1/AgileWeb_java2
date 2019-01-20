package lv.initex.console.services.taskListItems.getTaskListItems.validator;

import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.getTaskListItems.GetTaskListItemsRequest;
import lv.initex.console.services.taskListItems.getTaskListItems.validator.rules.GetTaskListItemEmptyRule;
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

    @Mock
    private GetTaskListItemEmptyRule getTaskListItemEmptyRule;

    @InjectMocks
    GetTaskListItemsValidatorImpl validator;

    @Test
    public void shouldReturnErrorList() {
        TaskList taskList = new TaskList();
        User user=new User();
        GetTaskListItemsRequest request=new GetTaskListItemsRequest(user,taskList);
        Mockito.when(getTaskListItemEmptyRule.execute(taskList))
                .thenReturn(Optional.of(new TaskListError("xxx", "yyy")));

                List<TaskListError> errors=validator.validate(request);

        assertTrue(!errors.isEmpty());
        assertEquals(errors.get(0).getField(), "xxx");
        assertEquals(errors.get(0).getDescription(),"yyy");
    }

    @Test
    public void shouldNotReturnErrorList() {
        TaskList taskList = new TaskList();
        User user=new User();
        GetTaskListItemsRequest request=new GetTaskListItemsRequest(user,taskList);
        Mockito.when(getTaskListItemEmptyRule.execute(taskList))
                .thenReturn(Optional.empty());

        List<TaskListError> errors=validator.validate(request);

        assertTrue(errors.isEmpty());
    }
}