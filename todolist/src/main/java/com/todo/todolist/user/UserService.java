package com.todo.todolist.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements Serializable {

    private final UserRepository userRepository;

    public List<UserDTO> findAll() {
        var list = userRepository.findAll();
        return list.stream()
                .map(UserDTO::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public UserDTO findById(Long id) throws Exception {
        var user = userRepository.findById(id);
        if (user.isPresent()) {
            var userDTO = new UserDTO();
            userDTO.setName(user.get().getName());
            userDTO.setAge(user.get().getAge());

            return userDTO;
        }
        throw new Exception("Not found");
    }

    public List<UserDTO> update(UserDTO user) throws Exception {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(userEntity.getName());
            userEntity.setAge(userEntity.getAge());
            userRepository.save(userEntity);

            return findAll();

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<UserDTO> delete(Long id) throws Exception {
        try {
            userRepository.deleteById(id);
            return findAll();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
