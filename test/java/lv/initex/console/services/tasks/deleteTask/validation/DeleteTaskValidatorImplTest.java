package lv.initex.console.services.tasks.deleteTask.validation;

import lv.initex.console.services.TaskListError;
import lv.initex.console.services.tasks.deleteTask.DeleteTaskRequest;
import lv.initex.console.services.tasks.deleteTask.validation.rules.DeleteTaskNotFoundRule;
import lv.initex.console.services.tasks.deleteTask.validation.rules.DeleteTitleIsEmptyRule;
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
public class DeleteTaskValidatorImplTest {

    @Mock
    DeleteTitleIsEmptyRule deleteTitleIsEmptyRule;

    @Mock
    DeleteTaskNotFoundRule deleteTaskNotFoundRule;

    @InjectMocks
    DeleteTaskValidatorImpl validator;

    @Test
    public void shouldCollectAndReturnErrors() {
        Mockito.when(deleteTaskNotFoundRule.execute("xxx"))
                .thenReturn(Optional.of(new TaskListError("title", "description-not found")));
        Mockito.when(deleteTitleIsEmptyRule.execute("xxx"))
                .thenReturn(Optional.of(new TaskListError("title", "description-empty")));

        List<TaskListError> errors = validator.validate(new DeleteTaskRequest("xxx"));
        assertEquals(errors.size(), 2);
    }


}