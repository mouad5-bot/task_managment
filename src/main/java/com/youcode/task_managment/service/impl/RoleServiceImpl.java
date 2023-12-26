package com.youcode.task_managment.service.impl;

import com.youcode.task_managment.domain.Role;
import com.youcode.task_managment.service.RoleService;
import com.youcode.task_managment.utils.ValidationException;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService {
    @Override
    public Role save(Role role) throws ValidationException {
        return null;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Role> getALlRoles() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Role findById(Long id) {
        return null;
    }
}
