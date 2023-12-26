package com.youcode.task_managment.repository;

import com.youcode.task_managment.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
