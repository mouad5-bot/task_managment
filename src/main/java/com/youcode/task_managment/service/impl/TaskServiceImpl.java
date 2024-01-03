package com.youcode.task_managment.service.impl;

import com.youcode.task_managment.domain.Tag;
import com.youcode.task_managment.domain.Task;
import com.youcode.task_managment.domain.User;
import com.youcode.task_managment.dtos.TaskDto;
import com.youcode.task_managment.dtos.mappers.TaskMapper;
import com.youcode.task_managment.repository.TaskRepository;
import com.youcode.task_managment.repository.UserRepository;
import com.youcode.task_managment.service.TagService;
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
    private final TagService tagService;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task add(Task task) throws Exception {
        taskCannotCreateInThePast(task);
        validateTags(task);
        return taskRepository.save(task);
    }

    @Override
    public TaskDto markTaskAsCompleted(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + taskId));

        // Check if the task is already completed
        if (task.isCompleted()) {
            throw new IllegalArgumentException("Task is already marked as completed.");
        }

        // Check if marking as completed is done before the deadline
        if (LocalDateTime.now().isAfter(task.getExpDate())) {
            throw new IllegalArgumentException("Task cannot be marked as completed after the deadline.");
        }

        // Mark the task as completed
        task.setCompleted(true);
        taskRepository.save(task);

        return taskMapper.toDto(task);
    }

    @Override
    public Task assignTask(Long idTask, Long idUser, LocalDateTime assignedDate ) throws Exception {
        Task task = taskRepository.findById(idTask).orElseThrow();
        User user = userRepository.findById(idUser).orElseThrow();

        Task.builder()
                .assignedDate(assignedDate)
                .user(user)
                .build();

        restrictTaskScheduling(task);

        return task;

    }

    @Override
    public List<Task> getAll(Pageable pageable) {
        return taskRepository.findAll(pageable).stream().toList();
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

        //here I want to check if tag already exists in database to skip saving it, else to save it!
        List<String> tagNames = task.getTags().stream().map(Tag::getName).toList();
        List<Tag> existingTags = tagService.findByNameIn(tagNames);

        task.setTags(existingTags);
    }

    private void restrictTaskScheduling(Task task) {
        LocalDate currentDate = LocalDate.now();
        LocalDate taskExpDate = task.getExpDate().toLocalDate();
        LocalDate taskAssigned = task.getAssignedDate().toLocalDate();
        LocalDate maxAllowedExpDate = currentDate.plusDays(3);

        if (taskExpDate.isBefore(maxAllowedExpDate))
            throw new IllegalArgumentException("Date expiration cannot be before assigned date !");

        if (taskAssigned.isBefore(maxAllowedExpDate))
            throw new IllegalArgumentException("the task cannot be assigned before 3 days form now !");
    }

}