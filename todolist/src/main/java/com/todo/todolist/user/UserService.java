package com.todo.todolist.user;

import com.todo.todolist.task.TaskDTO;
import com.todo.todolist.task.Task;
import com.todo.todolist.task.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
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
    private final TaskRepository taskRepository;

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
        User userEntity = new User();
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
                if (user.getName() != null) {
                    userEdit.get().setName(user.getName());
                }
                if (user.getPhoneNumber() != null) {
                    userEdit.get().setPhoneNumber(user.getPhoneNumber());
                }
                userRepository.save(userEdit.get());
            }
            return findAll();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<UserDTO> updateTasksByUser(List<TaskDTO> taskDTOList, Long id) throws Exception {
        try {
            var userEdit = userRepository.findById(id).orElseThrow();
            if (!taskDTOList.isEmpty()) {
                var listEntity = converterListaDTOparaEntidades(taskDTOList);
                listEntity.forEach(task -> {
                            var taskValue = taskRepository.findById(task.getId()).orElseThrow();
                            userEdit.addTask(taskValue);
                        });
                userRepository.save(userEdit);
            }
            return findAll();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public UserDTO updateSingleTaskByUser(TaskDTO taskDTO, Long id) throws Exception {
        try {
            var userEdit = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
            var task = convertDTOToEntity(taskDTO);
            var taskFinal = taskRepository.findById(task.getId()).orElseThrow(() -> new EntityNotFoundException("not found"));
            userEdit.addTask(taskFinal);
            userRepository.save(userEdit);

            return findById(id);
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

    public Task convertDTOToEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setNameTask(taskDTO.getNameTask());
        task.setDayOfWeek(taskDTO.getDayOfWeek());

        return task;
    }

    public List<Task> converterListaDTOparaEntidades(List<TaskDTO> dtoList) {
        List<Task> listaEntidades = new ArrayList<>();
        for (TaskDTO taskDTO : dtoList) {
            Task task = convertDTOToEntity(taskDTO);
            listaEntidades.add(task);
        }
        return listaEntidades;
    }

}
