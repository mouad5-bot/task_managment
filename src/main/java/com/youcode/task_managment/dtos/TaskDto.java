package com.youcode.task_managment.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.youcode.task_managment.domain.Task}
 */
public record TaskDto(Long id, String description, LocalDateTime expDate, boolean completed, LocalDateTime assignedDate,
                      boolean hasChanged, List<TagDto1> tags, UserDto user,
                      TaskChangeRequestDto taskChangeRequest) implements Serializable {
    /**
     * DTO for {@link com.youcode.task_managment.domain.Tag}
     */
    public record TagDto1(Long id, String name) implements Serializable {
    }

    /**
     * DTO for {@link com.youcode.task_managment.domain.User}
     */
    public record UserDto(Long id, String firstName, String lastName) implements Serializable {
    }

    /**
     * DTO for {@link com.youcode.task_managment.domain.TaskChangeRequest}
     */
    public record TaskChangeRequestDto(Long id) implements Serializable {
    }
}