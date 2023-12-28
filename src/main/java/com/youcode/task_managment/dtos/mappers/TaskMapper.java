package com.youcode.task_managment.dtos.mappers;

import com.youcode.task_managment.domain.Tag;
import com.youcode.task_managment.domain.Task;
import com.youcode.task_managment.dtos.TaskDto;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    @Mapping(source = "taskChangeRequestStatus", target = "taskChangeRequest.status")
    @Mapping(source = "taskChangeRequestDateRequest", target = "taskChangeRequest.dateRequest")
    @Mapping(source = "userLastName", target = "user.lastName")
    @Mapping(source = "userFirstName", target = "user.firstName")
    Task toEntity(TaskDto taskDto);

    @InheritInverseConfiguration(name = "toEntity")
    @Mapping(target = "tagNames", expression = "java(tagsToTagNames(task.getTags()))")
    TaskDto toDto(Task task);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task partialUpdate(TaskDto taskDto, @MappingTarget Task task);

    default List<String> tagsToTagNames(List<Tag> tags) {
        return tags.stream().map(Tag::getName).collect(Collectors.toList());
    }
}