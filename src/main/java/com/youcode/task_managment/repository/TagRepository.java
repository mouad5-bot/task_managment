package com.youcode.task_managment.repository;

import com.youcode.task_managment.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByNameIn(List<String> names);

}
