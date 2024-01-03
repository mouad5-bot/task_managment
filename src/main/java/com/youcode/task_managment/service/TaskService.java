package com.youcode.task_managment.service;

import com.youcode.task_managment.domain.Task;
import com.youcode.task_managment.dtos.TaskDto;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    Task add(Task task) throws Exception;

    TaskDto markTaskAsCompleted(Long taskId);
    Task assignTask(Long idTask, Long idUser, LocalDateTime assignedDate) throws Exception;

    List<Task> getAll(Pageable pageable);
}
