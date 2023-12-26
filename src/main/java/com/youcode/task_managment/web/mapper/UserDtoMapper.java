package com.youcode.task_managment.web.mapper;

import com.youcode.task_managment.domain.Role;
import com.youcode.task_managment.domain.User;
import com.youcode.task_managment.web.dto.request.UserRequestDto;
import com.youcode.task_managment.web.dto.response.UserResponseDto;

import java.util.ArrayList;
import java.util.List;

public class UserDtoMapper {



    private UserDtoMapper() {
    }

    public static User toEntity(UserRequestDto userDto) {
        List<Role> roles = new ArrayList<>();
        if(userDto.getAuthorities() != null){
            for (String role : userDto.getAuthorities()) {
                roles.add(Role.builder().name(role).build());
            }
        }
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }

    public static UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
