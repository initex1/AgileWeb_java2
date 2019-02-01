package lv.initex.web.controller;

import lv.initex.console.services.TaskListError;

import java.util.List;

public class ValidationError extends Exception{

    private List<TaskListError> errors;

    public ValidationError(List<TaskListError> errors) {
        this.errors = errors;
    }

    public List<TaskListError> getErrors() {
        return errors;
    }

    public void setErrors(List<TaskListError> errors) {
        this.errors = errors;
    }
}

