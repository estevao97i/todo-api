package com.todo.todolist.user;

import com.todo.todolist.task.TaskDTO;
import com.todo.todolist.task.TaskEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        try {
            var user = userRepository.findById(id);
            if (user.isPresent()) {
                var userDTO = new UserDTO();
                userDTO.setName(user.get().getName());
                userDTO.setPhoneNumber(user.get().getPhoneNumber());
                return userDTO;
            }
            throw new Exception("Not found");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<UserDTO> insert(UserDTO user) throws Exception {
        UserEntity userEntity = new UserEntity();
        try {
            userEntity.setName(user.getName());
            userEntity.setPhoneNumber(user.getPhoneNumber());
            userEntity.setListTasks(converterListaDTOparaEntidades(user.getTaskDTOList()));
            userRepository.save(userEntity);
            return findAll();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<UserDTO> update(UserDTO user) throws Exception {
        try {
            var userEdit = userRepository.findById(user.getId());
            if (userEdit.isPresent()) {
                userEdit.get().setId(user.getId());
                userEdit.get().setName(user.getName());
                userEdit.get().setPhoneNumber(user.getPhoneNumber());
                userEdit.get().setListTasks(converterListaDTOparaEntidades(user.getTaskDTOList()));
                userRepository.save(userEdit.get());
            }
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

    public TaskEntity convertDTOToEntity(TaskDTO taskDTO) {
        TaskEntity task = new TaskEntity();
        task.setId(taskDTO.getId());
        task.setNameTask(taskDTO.getNameTask());
        task.setDayOfWeek(taskDTO.getDayOfWeek());

        return task;
    }

    public List<TaskEntity> converterListaDTOparaEntidades(List<TaskDTO> dtoList) {
        List<TaskEntity> listaEntidades = new ArrayList<>();
        for (TaskDTO taskDTO : dtoList) {
            TaskEntity task = convertDTOToEntity(taskDTO);
            listaEntidades.add(task);
        }
        return listaEntidades;
    }

}
