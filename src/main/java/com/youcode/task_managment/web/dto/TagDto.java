package com.youcode.task_managment.web.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.youcode.task_managment.domain.Tag}
 */
@Data
@AllArgsConstructor
@Builder
@Value
public class TagDto implements Serializable {
    Long id;
    String name;
}