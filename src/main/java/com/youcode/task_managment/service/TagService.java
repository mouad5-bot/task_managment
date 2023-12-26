package com.youcode.task_managment.service;

import com.youcode.task_managment.domain.Tag;
import com.youcode.task_managment.domain.Task;

import java.util.List;

public interface TagService {
    Tag add(Tag tag);
    List<Tag> findByNameIn(List<Tag> names);

}
