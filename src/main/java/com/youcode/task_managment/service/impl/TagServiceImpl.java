package com.youcode.task_managment.service.impl;

import com.youcode.task_managment.domain.Tag;
import com.youcode.task_managment.repository.TagRepository;
import com.youcode.task_managment.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    @Override
    public Tag add(Tag tag){
        return tagRepository.save(tag);
    }
    @Override
    public List<Tag> findByNameIn(List<Tag> names) {
        return null;
    }
}