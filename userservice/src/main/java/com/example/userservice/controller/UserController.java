package com.example.userservice.controller;

import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.repository.RepositoryUser;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //class REST
//@CrossOrigin("http:localhost:3000") //allow frontend access
@RequestMapping("/user") //link with url
@RequiredArgsConstructor
public class UserController {
    private final RepositoryUser repository; //create object

    @GetMapping//link with http get
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping//link with http post
    User newUser(@RequestBody User newUser) { //convert data JSON to Java
        return repository.save(newUser);
    }

    @GetMapping("{id}")//link with http get
    User getUserById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("{id}")//link with http put
    ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Could not found the user with id " + id));
        return ResponseEntity.ok(repository.save(newUser));
    }

    @DeleteMapping("{id}")//link with http delete
    ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        repository.deleteById(id);
        return new ResponseEntity<String>("Usuario com id " + id + " foi excluido com sucesso!.", HttpStatus.OK);
    }
}