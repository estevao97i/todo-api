package com.todo.todolist.task;

import com.todo.todolist.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTask;

    private LocalDate dayOfWeek;

    @ManyToOne()
    private User user;
}
