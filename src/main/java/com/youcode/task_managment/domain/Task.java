package com.youcode.task_managment.domain;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime expDate;

    private boolean completed;

    private LocalDateTime assignedDate;

    private boolean hasChanged;

    @ManyToMany
    @JoinTable(
            name = "task_tags",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )

    private List<Tag> tags;

    @ManyToOne
    private User user;

    @OneToOne
    private TaskChangeRequest taskChangeRequest;
}
