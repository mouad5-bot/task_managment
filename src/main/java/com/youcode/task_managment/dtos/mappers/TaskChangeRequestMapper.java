package com.youcode.task_managment.dtos.mappers;

import com.youcode.task_managment.domain.TaskChangeRequest;
import com.youcode.task_managment.dtos.TaskChangeRequestDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskChangeRequestMapper {
    TaskChangeRequest toEntity(TaskChangeRequestDto taskChangeRequestDto);

    TaskChangeRequestDto toDto(TaskChangeRequest taskChangeRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskChangeRequest partialUpdate(TaskChangeRequestDto taskChangeRequestDto, @MappingTarget TaskChangeRequest taskChangeRequest);
}