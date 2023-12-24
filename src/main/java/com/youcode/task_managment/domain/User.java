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
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private  String password;
    @ManyToMany
    private List<Role> authorities;
    @OneToMany(mappedBy = "user")
    List<Task> tasks ;

}
