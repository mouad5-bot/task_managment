package com.youcode.task_managment.repository;

import com.youcode.task_managment.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
