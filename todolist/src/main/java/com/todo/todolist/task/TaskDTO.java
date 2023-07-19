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

    Long id;
    String nameTask;
    LocalDate dayOfWeek;

    public TaskDTO(TaskEntity task) {
        id = task.getId();
        nameTask = task.getNameTask();
        dayOfWeek = task.getDayOfWeek();
    }
}
