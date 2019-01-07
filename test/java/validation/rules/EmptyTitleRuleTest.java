package validation.rules;

import lv.services.TaskListError;
import lv.services.tasks.addTask.validation.rules.AddEmptyTitleRule;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EmptyTitleRuleTest {


    private AddEmptyTitleRule rule;

    @Before
    public void init() {
        rule = new AddEmptyTitleRule();
    }

    @Test
    public void shouldReturnErrorWhenTitleIsEmpty() {
        Optional<TaskListError> error = rule.execute("");
        assertEquals(error.isPresent(), true);
        assertEquals(error.get().getField(), "title");
        assertEquals(error.get().getDescription(), "Title field is empty");
    }

    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        Optional<TaskListError> error = rule.execute(null);
        assertEquals(error.isPresent(), true);
        assertEquals(error.get().getField(), "title");
        assertEquals(error.get().getDescription(), "Title field is empty");
    }

    @Test
    public void shouldNotReturnErrorWhenTitleIsNotEmpty(){
        Optional<TaskListError> error = rule.execute("title");
        assertEquals(error.isPresent(), false);
    }


}