package com.youcode.task_managment.repository;

import com.youcode.task_managment.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
