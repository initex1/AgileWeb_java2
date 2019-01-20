package lv.initex.console.services.taskLists.deleteTaskList.validation;

import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.deleteTaskList.DeleteTaskListRequest;
import lv.initex.console.services.taskLists.deleteTaskList.validation.rules.DeleteTaskListNoUserRule;
import lv.initex.console.services.taskLists.deleteTaskList.validation.rules.DeleteTaskListNotFoundRule;
import lv.initex.console.services.taskLists.deleteTaskList.validation.rules.DeleteTaskListTitleEmtyRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTaskListValidatorImplTest {

    @Mock
    DeleteTaskListTitleEmtyRule deleteTaskListTitleEmtyRule;

    @Mock
    DeleteTaskListNoUserRule deleteTaskListNoUserRule;

    @Mock
    DeleteTaskListNotFoundRule deleteTaskListNotFoundRule;

    @InjectMocks
    DeleteTaskListValidatorImpl validator;

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        User user=new User();

        DeleteTaskListRequest request=new DeleteTaskListRequest(user, "xxx");

        Mockito.when(deleteTaskListNoUserRule.execute(user))
                .thenReturn(Optional.of(new TaskListError("zzz", "aaa")));

        Mockito.when(deleteTaskListNotFoundRule.execute(user, "xxx"))
                .thenReturn(Optional.of(new TaskListError("xxx", "yyy")));

        Mockito.when(deleteTaskListTitleEmtyRule.execute( "xxx"))
                .thenReturn(Optional.of(new TaskListError("sss", "uuu")));

        List<TaskListError> error = validator.validate(request);

        assertEquals(3, error.size());

    }
}