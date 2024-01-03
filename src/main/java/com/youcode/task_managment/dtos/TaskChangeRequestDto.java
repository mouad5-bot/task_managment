package com.youcode.task_managment.dtos;

import com.youcode.task_managment.domain.enums.StatusRequest;
import com.youcode.task_managment.domain.enums.TokenType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.youcode.task_managment.domain.TaskChangeRequest}
 */
public record TaskChangeRequestDto(Long id, LocalDateTime dateRequest, StatusRequest status, TokenType tokenType,
                                   TaskDto1 task) implements Serializable {
    /**
     * DTO for {@link com.youcode.task_managment.domain.Task}
     */
    public record TaskDto1(Long id, String description) implements Serializable {
    }
}