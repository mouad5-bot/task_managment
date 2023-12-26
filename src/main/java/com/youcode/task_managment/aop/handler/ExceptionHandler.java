package com.youcode.task_managment.aop.handler;

import com.youcode.task_managment.exception.InsufficientTokensException;
import com.youcode.task_managment.exception.UnauthorizedException;
import com.youcode.task_managment.utils.CustomError;
import com.youcode.task_managment.utils.Response;
import com.youcode.task_managment.utils.ValidationException;
import com.youcode.task_managment.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    private Response<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Response<Object> response = new Response<>();
        List<CustomError> errorList = new ArrayList<>();
        response.setMessage("Validation error");
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = error.getObjectName();
            String errorMessage = error.getDefaultMessage();
            errorList.add(new CustomError(fieldName, errorMessage));
        });
        response.setErrors(errorList);
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    private Response<Object> handleValidationExceptions(ResourceNotFoundException ex) {
        Response<Object> response = new Response<>();
        List<CustomError> errorList = new ArrayList<>();
        response.setMessage("Resource not found");
        errorList.add(CustomError.builder()
                .field(ex.getField())
                .message(ex.getMessage())
                .build());
        response.setErrors(errorList);
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
    private Response<Object> handleValidationExceptions(ValidationException ex) {
        Response<Object> response = new Response<>();
        List<CustomError> errorList = new ArrayList<>();
        response.setMessage("Validation error");
        errorList.add(CustomError.builder()
                .field(ex.getCustomError().getField())
                .message(ex.getCustomError().getMessage())
                .build());
        response.setErrors(errorList);
        return response;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    private ResponseEntity<Response<Object>> handleValidationExceptions(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.internalServerError().body(Response.builder()
                .message("Internal server error")
                .result(ex.getMessage())
                .build());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @org.springframework.web.bind.annotation.ExceptionHandler({UnauthorizedException.class, InsufficientTokensException.class})
    public ResponseEntity<Response<Object>> handleUnauthorizedException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Response.builder()
                .message(ex.getMessage())
                .build());
    }
}