package lv.initex.console.services.taskLists.getTaskLists;

import lv.initex.console.database.TaskListRepository;
import lv.initex.console.domain.TaskList;
import lv.initex.console.services.TaskListError;
import lv.initex.console.services.taskLists.getTaskLists.validation.GetTaskListValidator;
import lv.initex.web.dtos.TaskListDTO;
import lv.initex.web.dtos.TaskListResponseDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetTaskListsServiceTest {

  //  private User user;

    private TaskListDTO request;

    @Mock
    private TaskListRepository database;

    @Mock
    private GetTaskListValidator validator;

    @InjectMocks
    private GetTaskListsService service;

    @Before
    public void init() {
          request = new TaskListDTO(new Long(1));
    }

    @Test
    public void shouldReturnTaskList() {
        TaskList taskList=new TaskList();
        taskList.setTaskTitle("xxx");
        Mockito.when(database.findAllByUser(request.getUserId()))
                .thenReturn(Arrays.asList(taskList));

        List<TaskListResponseDTO> response = service.getAllTaskLists(request);

        assertNotNull( response.get(0).getTaskListTitle());
        assertNull(response.get(0).getErrors());
    }

    @Test
    public void shouldReturnErrors() {
        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "vvv")));

        List<TaskListResponseDTO> response = service.getAllTaskLists(request);

        assertNull( response.get(0).getTaskListId());
        assertNotNull(response.get(0).getErrors());
    }

    @Test
    public void verifyThatDatabaseMethodWasCalledOnce() {
        Mockito.when(database.findAllByUser(request.getUserId()))
                .thenReturn(Arrays.asList(new TaskList()));

        List<TaskListResponseDTO> response = service.getAllTaskLists(request);
        verify(database).findAllByUser(request.getUserId());
    }

    @Test
    public void verifyThatValidatorWasCalledOnce() {
        Mockito.when(validator.validate(request))
                .thenReturn(Arrays.asList(new TaskListError("xxx", "vvv")));

        List<TaskListResponseDTO> response = service.getAllTaskLists(request);
        verify(validator).validate(request);
    }
}