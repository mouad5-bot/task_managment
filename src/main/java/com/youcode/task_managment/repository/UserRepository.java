package com.youcode.task_managment.repository;

import com.youcode.task_managment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
