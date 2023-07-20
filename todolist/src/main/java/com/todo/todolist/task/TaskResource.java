package com.todo.todolist.task;

import com.todo.todolist.user.UserConsultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/tasks")
@RequiredArgsConstructor
public class TaskResource {

    private final TaskService service;

    @GetMapping()
    public ResponseEntity<List<TaskDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping()
    public ResponseEntity<List<TaskDTO>> save(@RequestBody TaskDTO userDTO) {
        return ResponseEntity.ok(service.insert(userDTO));
    }

    @PutMapping()
    public ResponseEntity<List<TaskDTO>> update(@RequestBody TaskDTO userDTO) {
        return ResponseEntity.ok(service.update(userDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<TaskDTO>> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
