package com.youcode.task_managment.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.youcode.task_managment.domain.Task}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto implements Serializable {
    Long id;

    @NotEmpty
    String title;

    @NotEmpty
    String description;

    @NotNull
    LocalDateTime expDate;

    boolean completed;

    LocalDateTime assignedDate;

    boolean hasChanged;

    List<TagDto> tags;

    String createdByFirstName;

    String createdByLastName;

    String userFirstName;

    String userLastName;

    LocalDateTime userCreatedAt;
}