package com.example.userservice.controller;

import com.example.userservice.repository.RepositoryUser;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController //class REST
@CrossOrigin("http://localhost:3000") //allow frontend access
@RequestMapping("/user") //link with url
public class UserController {
    @Autowired //spring object autocreate
    private RepositoryUser repository; //create object

    @GetMapping//link with http get
    List<User> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping//link with http post
    User newUser(@RequestBody User newUser) { //convert data JSON to Java
        return repository.save(newUser);
    }

    @GetMapping("/{id}")//link with http get
    User getUserById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/{id}")//link with http put
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setNome(newUser.getNome());
                    user.setTelefone(newUser.getTelefone());
                    user.setIdade(newUser.getIdade());
                    return repository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/{id}")//link with http delete
    String deleteUser(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        repository.deleteById(id);
        return "Usuário com id " + id + " foi excluido com sucesso!.";
    }
}
