package com.youcode.task_managment.dtos;

import com.youcode.task_managment.domain.enums.StatusRequest;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.youcode.task_managment.domain.Task}
 */
public record TaskDto(@NotBlank String description, @Future LocalDateTime expDate, boolean completed,
                      @Future LocalDateTime assignedDate, boolean hasChanged, List<String> tagNames,
                      String userFirstName, String userLastName, LocalDateTime taskChangeRequestDateRequest,
                      StatusRequest taskChangeRequestStatus) implements Serializable {
}