package com.todo.todolist.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO implements Serializable {

    private Long id;
    private String nameTask;
    private LocalDate dayOfWeek;

    public TaskDTO(Task task) {
        id = task.getId();
        nameTask = task.getNameTask();
        dayOfWeek = task.getDayOfWeek();
    }
}
