package com.youcode.task_managment.web.mapper;

import com.youcode.task_managment.domain.Tag;
import com.youcode.task_managment.web.dto.TagDto;

public class TagDtoMapper {

    public static Tag mapToEntity(TagDto tag) {
        return Tag.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
    public static TagDto mapToDto(Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
}
