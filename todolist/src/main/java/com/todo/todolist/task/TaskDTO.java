package com.todo.todolist.task;

import com.todo.todolist.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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

    public TaskDTO(TaskEntity task) {
        id = task.getId();
        nameTask = task.getNameTask();
        dayOfWeek = task.getDayOfWeek();
    }
}
