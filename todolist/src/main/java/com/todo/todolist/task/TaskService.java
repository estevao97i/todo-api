package com.todo.todolist.task;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class TaskService implements Serializable {

    private final TaskRepository taskRepository;

    public List<TaskDTO> findAll() {
        try {
            var listAllTasks = taskRepository.findAll();
            var listAll = listAllTasks.stream()
                    .map(TaskDTO::new)
                    .collect(Collectors.toList());

            return listAll;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TaskDTO findById(Long id) {
        try {
            var task = taskRepository.findById(id);
            TaskDTO taskId = new TaskDTO();
            if (task.isPresent()) {
                taskId.setNameTask(task.get().getNameTask());
                taskId.setDayOfWeek(task.get().getDayOfWeek());
            }

            return taskId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<TaskDTO> insert(TaskDTO taskDTO) {
        try {

            var taskEntity = new Task();
            taskEntity.setNameTask(taskDTO.getNameTask());
            taskEntity.setDayOfWeek(taskDTO.getDayOfWeek());
            taskRepository.save(taskEntity);

            return findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<TaskDTO> update(TaskDTO taskDTO) {
        try {
            var taskEntity = new Task();
            taskEntity.setId(taskDTO.getId());
            taskEntity.setNameTask(taskDTO.getNameTask());
            taskEntity.setDayOfWeek(taskDTO.getDayOfWeek());
            taskRepository.saveAndFlush(taskEntity);

            return findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<TaskDTO> delete(Long id) {
        try {
            taskRepository.deleteById(id);
            return findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
