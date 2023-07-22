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

    public UserConsultDTO(User user) {
        name = user.getName();
        phoneNumber = user.getPhoneNumber();
    }
}
