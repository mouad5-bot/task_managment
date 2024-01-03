package com.youcode.task_managment.utils;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomError {
    private final String field;
    private final String message;
}
