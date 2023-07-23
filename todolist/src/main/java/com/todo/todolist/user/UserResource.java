package com.todo.todolist.user;

import com.todo.todolist.task.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<List<UserDTO>> save(@RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity.ok(userService.insert(userDTO));
    }

    @PutMapping()
    public ResponseEntity<List<UserDTO>> update(@RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity.ok(userService.update(userDTO));
    }

    @PutMapping(value = "/update-task/{id}")
    public ResponseEntity<List<UserDTO>> updateTasksByUser(@RequestBody List<TaskDTO> taskDTOList, @PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(userService.updateTasksByUser(taskDTOList, id));
    }

    @PutMapping(value = "/insert-task/{id}")
    public ResponseEntity<UserDTO> updateSingleTaskByUser(@RequestBody TaskDTO taskDTO, @PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(userService.updateSingleTaskByUser(taskDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<UserDTO>> delete(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(userService.delete(id));
    }
}
