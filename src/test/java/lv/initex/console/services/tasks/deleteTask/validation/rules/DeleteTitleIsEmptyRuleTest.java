package lv.initex.console.services.tasks.deleteTask.validation.rules;

import lv.initex.console.services.TaskListError;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class DeleteTitleIsEmptyRuleTest {

    private DeleteTitleIsEmptyRule rule;

    @Before
    public void init() {
        rule = new DeleteTitleIsEmptyRule();
    }

    @Test
    public void shouldReturnErrorIfTitleIsEmpty(){
        Optional<TaskListError> errors=rule.execute("");

        assertTrue(errors.isPresent());
        assertEquals(errors.get().getField(), "title");
        assertEquals(errors.get().getDescription(),"Delete task field is empty!");
    }

    @Test
    public void shouldReturnErrorIfTitleIsNull(){
        Optional<TaskListError> errors=rule.execute(null);

        assertTrue(errors.isPresent());
        assertEquals(errors.get().getField(), "title");
        assertEquals(errors.get().getDescription(),"Delete task field is empty!");
    }

    @Test
    public void shouldNotReturnErrorIfTitleNotEmpty(){
        Optional<TaskListError> errors=rule.execute("title");

        assertTrue(errors.isPresent());
    }
}