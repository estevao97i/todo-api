package com.todo.todolist.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    Long id;
    String name;
    String age;

    public UserDTO(UserEntity userEntity) {
        id = userEntity.getId();
        name = userEntity.getName();
        age = userEntity.getAge();
    }
}
