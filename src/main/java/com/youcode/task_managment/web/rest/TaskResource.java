package com.youcode.task_managment.web.rest;

import com.youcode.task_managment.domain.Task;
import com.youcode.task_managment.dtos.TaskDto;
import com.youcode.task_managment.dtos.mappers.TaskMapper;
import com.youcode.task_managment.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task/")
public class TaskResource {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    @PostMapping("add")
    public ResponseEntity<Task> add(@RequestBody @Valid TaskDto task) throws Exception {
        Task save = taskService.add(taskMapper.toEntity(task));
        return ResponseEntity.ok(save);
    }

    @PostMapping("assign")
    public ResponseEntity<Task> assignTask(@RequestBody Long idTask, Long idUser, LocalDateTime assignedDate) throws Exception {
        Task assign = taskService.assignTask(idTask, idUser, assignedDate);
        return ResponseEntity.ok(assign);
    }
    @PostMapping("{id}/completed")
    public ResponseEntity<TaskDto> completeTask(@PathVariable("id") Long idTask) throws Exception {
        TaskDto complete = taskService.markTaskAsCompleted(idTask);
        return ResponseEntity.ok(complete);
    }

    @GetMapping("all")
    public ResponseEntity<List<TaskDto>> getAllTasks(@ParameterObject Pageable pageable) {

        List<Task> taskList = taskService.getAll(pageable);

        return ResponseEntity.ok(taskList.stream()
                .map(taskMapper::toDto)
                .toList()
        );
    }

}
