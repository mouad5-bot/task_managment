package com.youcode.task_managment.exception;

public class EmailOrPasswordIncorrectException extends RuntimeException {

    public EmailOrPasswordIncorrectException(String message) {
        super(message);
    }
}