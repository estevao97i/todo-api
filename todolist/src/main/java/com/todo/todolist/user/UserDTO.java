package com.todo.todolist.user;

import com.todo.todolist.task.TaskDTO;
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

    Long id;
    String name;
    String phoneNumber;

    List<TaskDTO> taskDTOList;

    public UserDTO(UserEntity userEntity) {
        id = userEntity.getId();
        name = userEntity.getName();
        phoneNumber = userEntity.getPhoneNumber();
        taskDTOList = userEntity.getListTasks().stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
    }
}
