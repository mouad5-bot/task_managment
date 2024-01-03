package com.youcode.task_managment.service.impl;

import com.youcode.task_managment.domain.User;
import com.youcode.task_managment.repository.UserRepository;
import com.youcode.task_managment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User add(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable).stream().toList();
    }
}
