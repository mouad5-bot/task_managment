package com.youcode.task_managment.dtos;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link com.youcode.task_managment.domain.Role}
 */
public record RoleDto(Long id, @NotBlank String name) implements Serializable {
}