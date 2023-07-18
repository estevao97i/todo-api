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
public class UserConsultDTO implements Serializable {

    String name;
    String age;

    public UserConsultDTO(UserEntity userEntity) {
        name = userEntity.getName();
        age = userEntity.getAge();
    }
}
