package com.todo.todolist.user;

import com.todo.todolist.task.Task;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Task> listTasks = new ArrayList<>();

    public void addTask(Task task) {
        listTasks.add(task);
        task.setUser(this);
    }

    public void removeTask(Task task) {
        listTasks.remove(task);
        task.setUser(null);
    }
}
