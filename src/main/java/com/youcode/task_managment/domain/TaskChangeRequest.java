package com.youcode.task_managment.domain;
import com.youcode.task_managment.domain.enums.StatusRequest;
import com.youcode.task_managment.domain.enums.TokenType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskChangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateRequest;

    @Enumerated(EnumType.STRING)
    private StatusRequest status;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    @OneToOne
    private Task task;

}
