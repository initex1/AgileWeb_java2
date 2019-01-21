package lv.initex.console.services.taskListItems.addTaskListItem;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.addTaskListItem.validate.AddTaskListItemValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddTaskListItemServiceTest {

    private AddTaskListItemRequest request;

    @Mock
    private TaskListItemRepository database;

    @Mock
    private AddTaskListItemValidator validator;

    @InjectMocks
    private AddTaskListItemService service;

    @Before
    public void init() {
        request = new AddTaskListItemRequest(new TaskList(), new Task());
    }

    @Test
    public void shouldReturnResponseWithErrorListAndNoTaskListItemId() {
        List<TaskListError> errors = Arrays.asList(new TaskListError("TaskListItem", "Duplicate taskListItem"));
        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        AddTaskListItemResponse response = service.add(request);

        assertNull(response.getTaskListItemId());
        assertEquals(response.getErrors().size(), 1);
    }


    @Test
    public void verifyThatValidatorWasCalledOnce() {
        AddTaskListItemResponse response = service.add(request);

        verify(validator).validate(request);
    }

    @Test
    public void verifyThatDatabaseAddMethodWasCalledOnce() {
        AddTaskListItemResponse response = service.add(request);

        verify(database).save(any(TaskListItem.class));
    }

}