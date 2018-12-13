package validation;

import lv.services.Error;
import lv.services.addTask.AddTaskRequest;
import lv.services.addTask.validation.AddTaskValidator;
import lv.services.addTask.validation.AddTaskValidatorImpl;
import lv.services.addTask.validation.rules.AddDuplicateTaskTitleRule;
import lv.services.addTask.validation.rules.AddEmptyTitleRule;
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
public class AddTaskValidatorImplTest {

    @Mock
    private AddEmptyTitleRule emptyTitleRule;

    @Mock
    private AddDuplicateTaskTitleRule duplicateProductTitleRule;

    @InjectMocks
    private AddTaskValidator validator = new AddTaskValidatorImpl();

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        Mockito.when(emptyTitleRule.execute("homework1"))
                .thenReturn(Optional.of(new Error("title", "des")));

        Mockito.when(duplicateProductTitleRule.execute("homework1"))
                .thenReturn(Optional.of(new Error("title", "duplicate")));

        List<Error> errors = validator.validate(
                new AddTaskRequest("homework1")
        );

        assertEquals(errors.size(), 2);
    }

}