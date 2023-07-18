package com.todo.todolist.user;

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
    public ResponseEntity<UserConsultDTO> findById(@PathVariable("id") Long id) throws Exception {
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<UserDTO>> update(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(userService.delete(id));
    }
}
