package lv.initex.console.services.taskLists.addTaskList;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.domain.User;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskListItems.addTaskListItem.AddTaskListItemService;
import lv.initex.console.services.taskLists.addTaskList.validation.AddTaskListValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddTaskListServiceTest {

  //  private User user;

    private AddTaskListRequest request;

    @Mock
    private TaskListRepository database;

    @Mock
    private AddTaskListValidator validator;

    @InjectMocks
    private AddTaskListService service;

    @Before
    public void init() {
       // user = new User();
        request = new AddTaskListRequest(new Long(1), "xxx");
    }

    @Test
    public void shouldReturnResponseWithErrorsListAndNoTaskListId() {
        List<TaskListError> errors = Arrays.asList(new TaskListError("List xxx", "yyy"));

        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        AddTaskListResponse response = service.add(request);

        assertNull(response.getTaskListId());
        assertEquals(1, response.getErrors().size());
    }

    @Test
    public void verifyThatDatabaseAddMethodWasCalledOnce() {
        AddTaskListResponse response = service.add(request);

        verify(database).save(any(TaskList.class));
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        AddTaskListResponse response = service.add(request);

        verify(validator).validate(request);
    }
}