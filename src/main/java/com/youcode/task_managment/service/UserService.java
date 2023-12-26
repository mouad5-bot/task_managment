package com.youcode.task_managment.service;

import com.youcode.task_managment.domain.User;
import com.youcode.task_managment.utils.ValidationException;

import java.util.List;

public interface UserService { User save(User user) throws ValidationException;
    User update(User user);
    User delete(User user);
    List<User> findAll();
}
