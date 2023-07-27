package com.todo.todolist.service;

import com.todo.todolist.user.User;
import com.todo.todolist.user.UserDTO;
import com.todo.todolist.user.UserRepository;
import com.todo.todolist.user.UserService;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Autowired
    public UserService service;

    UserDTO user = new UserDTO();

    @BeforeEach
    public void setUp() {
        user.setName("edeovaldo");
        user.setPhoneNumber("61997855452");
        user.setTaskDTOList(new ArrayList<>());
    }

    @Test
    public void testReturnUserWhenAddUserTest() throws Exception {

        var returnLengthUsers = service.findAll().size();

        service.insert(user);

        var newReturnLengthUsers = service.findAll().size();

        Assertions.assertEquals(returnLengthUsers + 1, newReturnLengthUsers);
    }
}
