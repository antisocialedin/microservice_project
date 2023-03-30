package com.example.rest_api;

import com.example.rest_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000") //allow frontend access
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

//    @GetMapping
//    public void user(){
//
//        this.restTemplate.exchange("http://userservice/user", HttpMethod.GET, null, User.class);
//
//        System.out.println(user.getBody().getNome());
//        System.out.println(user.getBody().getIdade());
//        System.out.println(user.getBody().getTelefone());
//    }

}
