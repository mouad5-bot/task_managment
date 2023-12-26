package com.youcode.task_managment.service;

import com.youcode.task_managment.domain.Role;
import com.youcode.task_managment.utils.ValidationException;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role save(Role role) throws ValidationException;
    Optional<Role> findByName(String name) ;
    List<Role> getALlRoles();
    void delete(Long id);

    Role findById(Long id);
}
