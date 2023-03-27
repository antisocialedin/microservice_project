package com.crud.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.restapi.exception.UserNotFoundException;
import com.crud.restapi.model.User;
import com.crud.restapi.repository.RepositoryUser;

@RestController //class REST
@CrossOrigin("http://localhost:3000") //allow frontend access
// @RequestMapping("/user") //link with url

public class UserController{
    @Autowired //spring object autocreate
    private RepositoryUser repository; //create object

    @GetMapping("/users") //link with http get
    List<User> getAllUsers(){
        return repository.findAll();
    }

    @PostMapping("/user") //link with http post
    User newUser(@RequestBody User newUser){ //convert data JSON to Java
        return repository.save(newUser);
    }

    @GetMapping("/user/{id}") //link with http get
    User getUserById(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}") //link with http put
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setNome(newUser.getNome());
                    user.setTelefone(newUser.getTelefone());
                    user.setIdade(newUser.getIdade());
                    return repository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}") //link with http delete
    String deleteUser(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        repository.deleteById(id);
        return  "Usuário com id "+id+" foi excluido com sucesso!.";
    }
}
