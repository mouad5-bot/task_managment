package com.youcode.task_managment.service.impl;

import com.youcode.task_managment.domain.Tag;
import com.youcode.task_managment.repository.TagRepository;
import com.youcode.task_managment.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Tag> findByNameIn(List<String> names) {
        List<String> tags = new ArrayList<>(names);
        List<Tag> existingTags = tagRepository.findByNameIn(names);
        if (existingTags.size() == tags.size()) {
            return existingTags;
        }
        existingTags.forEach(tag -> tags.remove(tag.getName()));
        tags.forEach(name -> existingTags.add(tagRepository.save(Tag.builder().name(name).build())));
        return existingTags;
    }

    @Override
    public List<Tag> getAll(Pageable p) {
        return tagRepository.findAll(p).toList();
    }
}
