package com.youcode.task_managment.web.rest;

import com.youcode.task_managment.domain.Tag;
import com.youcode.task_managment.dtos.TagDto;
import com.youcode.task_managment.dtos.mappers.TagMapper;
import com.youcode.task_managment.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tag/")
public class TagResource {
    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping("all")
    public ResponseEntity<List<TagDto>> getAll(@ParameterObject Pageable pageable)
             {
        List<Tag> tagList = tagService.getAll(pageable);

        return ResponseEntity.ok(tagList.stream()
                .map(tagMapper::toDto)
                .toList()
        );
    }
}
