package com.youcode.task_managment.web.rest;

import com.youcode.task_managment.domain.Task;
import com.youcode.task_managment.service.TaskService;
import com.youcode.task_managment.web.dto.TaskDto;
import com.youcode.task_managment.web.mapper.TaskDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task/")
public class TaskRest {
    private final TaskService taskService;
    @PostMapping("add")
    public ResponseEntity<Task> add(@RequestBody TaskDto task) throws Exception {
        Task save = taskService.add(TaskDtoMapper.mapToEntity(task));
        return ResponseEntity.ok(save);
    }

    @GetMapping("all")
    public ResponseEntity<List<TaskDto>> getAllTasks(@ParameterObject Pageable pageable) {

        List<Task> taskList = taskService.getAll(pageable);

        return ResponseEntity.ok(taskList.stream()
                .map(TaskDtoMapper::mapToDto)
                .toList()
        );
    }

}
