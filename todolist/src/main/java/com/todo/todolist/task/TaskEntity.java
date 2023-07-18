package com.todo.todolist.task;

import com.todo.todolist.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTask;

    @ManyToOne()
    private UserEntity userEntity;
}
