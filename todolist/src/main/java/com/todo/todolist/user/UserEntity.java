package com.todo.todolist.user;

import com.todo.todolist.task.TaskEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String age;

    @OneToMany(mappedBy = "userEntity")
    private List<TaskEntity> listTasks = new ArrayList<>();
}
