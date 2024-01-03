package com.youcode.task_managment.service;

import com.youcode.task_managment.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User add(User user) throws Exception;
    List<User> getAll(Pageable pageable);
}
