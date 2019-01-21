package lv.initex.console.services.tasks.addTask.validation.rules;

import lv.initex.console.services.TaskListError;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class AddEmptyTitleRuleTest {

    private AddEmptyTitleRule rule;

    @Before
    public void init() {
        rule = new AddEmptyTitleRule();
    }

    @Test
    public void shouldReturnErrorWhenTitleIsEmpty() {
        Optional<TaskListError> error = rule.execute("");

        assertTrue(error.isPresent());
        assertEquals(error.get().getField(), "title");
        assertEquals(error.get().getDescription(), "Title field is empty");
    }

    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        Optional<TaskListError> error = rule.execute(null);

        assertTrue(error.isPresent());
        assertEquals(error.get().getField(), "title");
        assertEquals(error.get().getDescription(), "Title field is empty");
    }

    @Test
    public void shouldNotReturnErrorWhenTitleIsNotEmpty(){
        Optional<TaskListError> error = rule.execute("title");

        assertFalse(error.isPresent());
    }

}