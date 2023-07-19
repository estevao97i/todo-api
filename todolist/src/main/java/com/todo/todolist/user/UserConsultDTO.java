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
    String phoneNumber;

    public UserConsultDTO(UserEntity userEntity) {
        name = userEntity.getName();
        phoneNumber = userEntity.getPhoneNumber();
    }
}
