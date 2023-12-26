package com.youcode.task_managment.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ValidationException extends Throwable{
    private CustomError customError;
}
