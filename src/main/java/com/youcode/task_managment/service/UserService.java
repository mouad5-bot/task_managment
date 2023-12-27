package com.youcode.task_managment.service;

import com.youcode.task_managment.domain.User;
import com.youcode.task_managment.utils.ValidationException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User save(User user) throws ValidationException;
    List<User> findAll(Pageable pageable);
    User delete(User user);
}
