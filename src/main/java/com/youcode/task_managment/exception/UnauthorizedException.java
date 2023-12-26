package com.youcode.task_managment.exception;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String s) {
        super(s);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}