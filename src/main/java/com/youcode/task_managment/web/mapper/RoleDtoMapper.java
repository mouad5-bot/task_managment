package com.youcode.task_managment.web.mapper;

import com.youcode.task_managment.domain.Role;
import com.youcode.task_managment.web.dto.RoleDto;

public class RoleDtoMapper {
    private RoleDtoMapper() {
    }

    public static RoleDto toDto(Role role)
    {
        return RoleDto.builder().id(role.getId()).name(role.getName()).build();
    }

    public static Role toRole(RoleDto roleDto)
    {
        return Role.builder().id(roleDto.getId()).name(roleDto.getName()).build();
    }


}
