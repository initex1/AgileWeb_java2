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
    private DeleteTaskListTitleEmtyRule deleteTaskListTitleEmtyRule;

    @Mock
    private DeleteTaskListNoUserRule deleteTaskListNoUserRule;

    @Mock
    private DeleteTaskListNotFoundRule deleteTaskListNotFoundRule;

    @InjectMocks
    private DeleteTaskListValidatorImpl validator;

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        User user = new User();

        DeleteTaskListRequest request = new DeleteTaskListRequest(new Long(1), "xxx");

        Mockito.when(deleteTaskListNoUserRule.execute(request.getUserId()))
                .thenReturn(Optional.of(new TaskListError("zzz", "aaa")));

        Mockito.when(deleteTaskListNotFoundRule.execute(request.getUserId(), "xxx"))
                .thenReturn(Optional.of(new TaskListError("xxx", "yyy")));

        Mockito.when(deleteTaskListTitleEmtyRule.execute("xxx"))
                .thenReturn(Optional.of(new TaskListError("sss", "uuu")));

        List<TaskListError> error = validator.validate(request);

        assertEquals(3, error.size());

    }
}