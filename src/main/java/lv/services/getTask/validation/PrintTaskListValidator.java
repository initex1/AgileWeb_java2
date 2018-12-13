package lv.services.getTask.validation;

import lv.services.Error;

import java.util.List;

public interface PrintTaskListValidator {
    List<Error>validate();
}
