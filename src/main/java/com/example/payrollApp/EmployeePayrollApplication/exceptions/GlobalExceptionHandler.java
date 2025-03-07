package com.example.payrollApp.EmployeePayrollApplication.exceptions;

import com.example.payrollApp.EmployeePayrollApplication.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final String message = "Exception while processing REST request!";
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        log.error("Some method argument validation error in global exception");
        return new ResponseEntity<>(new ResponseDto("Validation Failed", errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ResponseDto> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(new ResponseDto("Employee Not Found", ex.getMessage()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<ResponseDto> handleEmployeeAlreadyExists(EmployeeAlreadyExistsException ex) {
        return new ResponseEntity<>(new ResponseDto("Employee Already Exists", ex.getMessage()), HttpStatus.CONFLICT);
    }


    @ExceptionHandler(InvalidEmployeeDataException.class)
    public ResponseEntity<ResponseDto> handleInvalidEmployeeData(InvalidEmployeeDataException ex) {
        return new ResponseEntity<>(new ResponseDto("Invalid Employee Data", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleGlobalExceptions(Exception ex) {
        return new ResponseEntity<>(new ResponseDto("Error Occurred", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
