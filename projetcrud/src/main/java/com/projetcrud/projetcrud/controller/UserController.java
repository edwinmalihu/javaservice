package com.projetcrud.projetcrud.controller;

import com.projetcrud.projetcrud.entity.UserModel;
import com.projetcrud.projetcrud.repository.UserRepository;
import org.hibernate.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public UserModel AddUser(@RequestBody UserModel req) {
        var result = userRepository.save(req);
        return result;
    }

    @GetMapping("/detail")
    public Optional<UserModel> GetUserById (@RequestParam("id") Long req){
        var result = userRepository.findById(req);
        return result;
    }

    @PostMapping("/addarr")
    public  List<UserModel> AddUserArr(@RequestBody List<UserModel> req){

        List<UserModel> userModels = userRepository.saveAll(req);
        return userModels;
    }

    // other controller methods
}