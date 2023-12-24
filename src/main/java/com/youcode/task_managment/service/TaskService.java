package com.youcode.task_managment.service;

import com.youcode.task_managment.domain.Task;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    Task add(Task task) throws Exception;
    List<Task> getAll(Pageable pageable);
}
