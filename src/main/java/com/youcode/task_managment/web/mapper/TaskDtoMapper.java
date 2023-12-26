package com.youcode.task_managment.web.mapper;

import com.youcode.task_managment.domain.Task;
import com.youcode.task_managment.web.dto.TaskDto;

public class TaskDtoMapper {

    public static Task mapToEntity(TaskDto task) {
        return Task.builder()
                .id(task.getId())
                .description(task.getDescription())
                .expDate(task.getExpDate())
                .completed(task.isCompleted())
                .hasChanged(task.isHasChanged())
                .tags(task.getTags().stream().map(TagDtoMapper::mapToEntity).toList())
                .build();
    }

    public static TaskDto mapToDto(Task task){
        return TaskDto.builder()
                .id(task.getId())
                .description(task.getDescription())
                .expDate(task.getExpDate())
                .completed(task.isCompleted())
                .hasChanged(task.isHasChanged())
                .tags(
                        task.getTags()
                                .stream()
                                .map( TagDtoMapper::mapToDto)
                                .toList()
                )
                .build();
    }
}
