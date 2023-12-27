package com.youcode.task_managment.service.impl;

import com.youcode.task_managment.domain.User;
import com.youcode.task_managment.repository.UserRepository;
import com.youcode.task_managment.service.UserService;
import com.youcode.task_managment.utils.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User save(User user) throws ValidationException {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll(Pageable p ) {
        return userRepository.findAll(p).toList();
    }

    @Override
    public User delete(User user) {
        return null;
    }
}
