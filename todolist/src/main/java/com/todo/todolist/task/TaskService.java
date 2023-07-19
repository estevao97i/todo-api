package com.todo.todolist.task;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Transactional
@Service
@RequiredArgsConstructor
public class TaskService implements Serializable {

    private final TaskRepository taskRepository;


}
