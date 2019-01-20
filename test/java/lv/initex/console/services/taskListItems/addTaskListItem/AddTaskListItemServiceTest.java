package lv.initex.console.services.taskListItems.addTaskListItem;

import lv.initex.console.database.TaskListItemRepository;
import lv.initex.console.domain.Task;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.TaskListItem;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.addTaskListItem.validate.AddTaskListItemValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddTaskListItemServiceTest {

    @Mock
    TaskListItemRepository database;

    @Mock
    AddTaskListItemValidator validator;

    @InjectMocks
    AddTaskListItemService service;

    @Test
    public void shouldReturnResponseWithErrorListAndNoTaskListItemId() {
        AddTaskListItemRequest request = new AddTaskListItemRequest(new TaskList(), new Task());
        List<TaskListError> errors = Arrays.asList(new TaskListError("TaskListItem", "Duplicate taskListItem"));
        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        AddTaskListItemResponse response = service.add(request);

        assertEquals(response.getTaskListItemId(), null);
        assertEquals(response.getErrors().size(), 1);
    }


    @Test
    public void verifyThatValidatorWasCalledOnce() {
        AddTaskListItemRequest request = new AddTaskListItemRequest(new TaskList(), new Task());

        AddTaskListItemResponse response = service.add(request);
        verify(validator, times(1)).validate(anyObject());
    }

    @Test
    public void verifyThatDatabaseAddMethodWasCalledOnce(){
        AddTaskListItemRequest request = new AddTaskListItemRequest(new TaskList(), new Task());

        AddTaskListItemResponse response = service.add(request);
        verify(database, times(1)).save(anyObject());
    }

}