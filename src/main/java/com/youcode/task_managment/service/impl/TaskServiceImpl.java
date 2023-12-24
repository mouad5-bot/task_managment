package com.youcode.task_managment.service.impl;

import com.youcode.task_managment.domain.Tag;
import com.youcode.task_managment.domain.Task;
import com.youcode.task_managment.repository.TaskRepository;
import com.youcode.task_managment.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Override
    public Task add(Task task) throws Exception {
        taskCannotCreateInThePast(task);
        validateTags(task);
        restrictTaskScheduling(task);
        return taskRepository.save(task);
    }

    private void taskCannotCreateInThePast(Task task) {

        if (task.getAssignedDate() != null && task.getAssignedDate().isBefore(LocalDateTime.now()) ){
            throw new IllegalArgumentException("The date is in the past !");
        }
    }
    private void validateTags(Task task) {
        if (task.getTags() == null || task.getTags().size() < 2) {
            throw new IllegalArgumentException("At least 2 tags is required !");
        }
        //check if the tags existe dont save it , if not add it in tag database
    }

    private void restrictTaskScheduling(Task task) throws Exception {
        LocalDate currentDate = LocalDate.now();
        LocalDate taskExpDate = task.getExpDate().toLocalDate();
        LocalDate taskAssigned = task.getAssignedDate().toLocalDate();
        LocalDate maxAllowedExpDate = currentDate.plusDays(3);

        if (taskExpDate.isBefore(maxAllowedExpDate))
            throw new Exception("Date expiration cannot be before assigned date !");

        if (taskAssigned.isBefore(maxAllowedExpDate))
            throw new Exception("the task cannot be assigned before 3 days form now !");
    }

    @Override
    public List<Task> getAll(Pageable pageable) {
        return null;
    }
}