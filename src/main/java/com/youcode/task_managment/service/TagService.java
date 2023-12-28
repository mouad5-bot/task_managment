package com.youcode.task_managment.service;

import com.youcode.task_managment.domain.Tag;
import com.youcode.task_managment.domain.Task;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    Tag add(Tag tag);
    List<Tag> findByNameIn(List<Tag> names);
    List<Tag> getAll(Pageable p);

}
