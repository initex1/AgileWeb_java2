package lv.initex.console.services.taskLists.addTaskList.validation;

import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.addTaskList.AddTaskListRequest;
import lv.initex.console.services.taskLists.addTaskList.validation.rules.AddDuplicateTaskListTitleRule;
import lv.initex.console.services.taskLists.addTaskList.validation.rules.AddEmptyTaskListTitleRule;
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
public class AddTaskListValidatorImplTest {

    @Mock
    AddDuplicateTaskListTitleRule addDuplicateTaskListtitleRule;

    @Mock
    AddEmptyTaskListTitleRule addEmptyTaskListTitleRule;

    @InjectMocks
    AddTaskListValidatorImpl validator;

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        User user = new User();
        AddTaskListRequest request=new AddTaskListRequest(user,"xxx");

        Mockito.when(addEmptyTaskListTitleRule.execute("xxx"))
                .thenReturn(Optional.of(new TaskListError("title", "empty")));

        Mockito.when((addDuplicateTaskListtitleRule.execute(user, "xxx")))
                .thenReturn(Optional.of(new TaskListError("title", "duplicate")));

        List<TaskListError> errors=validator.validate(request);

        assertEquals(errors.size(), 2);
    }
}