package lv.initex.console.services.tasks.getTask.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.getTask.validation.rules.GetTasksEmptyRule;
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
public class GetTasksValidatorImplTest {

    @Mock
    GetTasksEmptyRule getTaskListEmptyRule;

    @InjectMocks
    GetTasksValidatorImpl validator;

    @Test
    public void shouldReturnErrorList() {
        Mockito.when(getTaskListEmptyRule.execute())
                .thenReturn(Optional.of(new TaskListError("xxx", "yyy")));
        List<TaskListError> errors = validator.validate();
        assertTrue(!errors.isEmpty());
        assertEquals(errors.get(0).getField(), "xxx");
        assertEquals(errors.get(0).getDescription(),"yyy");
    }

    @Test
    public void shouldNotReturnErrorList() {
        Mockito.when(getTaskListEmptyRule.execute()).thenReturn(Optional.empty());
        List<TaskListError> errors = validator.validate();
        assertTrue(errors.isEmpty());
    }

}