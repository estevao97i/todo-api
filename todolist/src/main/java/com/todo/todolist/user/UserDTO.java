package com.todo.todolist.user;

import com.todo.todolist.task.TaskDTO;
import com.todo.todolist.task.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String phoneNumber;
    private List<TaskDTO> taskDTOList;

    public UserDTO(UserEntity userEntity) {
        id = userEntity.getId();
        name = userEntity.getName();
        phoneNumber = userEntity.getPhoneNumber();
        taskDTOList = userEntity.getListTasks().stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
    }
}
