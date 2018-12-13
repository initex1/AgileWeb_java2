package lv.services.getTask.validation;

import lv.services.Error;
import lv.services.getTask.validation.rules.PrintTaskListEmptyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrintTaskListValidatorImpl implements PrintTaskListValidator {

    @Autowired
    private PrintTaskListEmptyRule printTaskListEmptyRule;

    @Override
    public List<Error> validate() {
        List<Error> errors = new ArrayList<>();
        printTaskListEmptyRule.execute().ifPresent(errors::add);
        return errors;
    }
}
