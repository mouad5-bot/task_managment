package com.youcode.task_managment.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private  String password;

    @ManyToMany
    private List<Role> authorities;

    @OneToMany(mappedBy = "user")
    List<Task> tasks;

}
