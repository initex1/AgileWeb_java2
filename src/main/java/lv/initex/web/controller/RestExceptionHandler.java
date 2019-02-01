package lv.initex.web.controller;

import lv.initex.web.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ValidationError.class)
    protected ResponseEntity<Object> handleValidationException(ValidationError exception) {
        return buildResponseEntity(new ErrorDTO(HttpStatus.BAD_REQUEST, exception.getErrors()));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorDTO errorDTO) {
        return new ResponseEntity<>(errorDTO, errorDTO.getStatus());
    }
}