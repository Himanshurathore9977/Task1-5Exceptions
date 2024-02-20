package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;

    @GetMapping
    public List<User> getUser(){
        return userService.getAllUser() ;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id ){
        return userService.getUserById(id) ;
    }


    @PostMapping
    public User createUser(@RequestBody User user ){
        return userService.createUser(user) ;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id  , @RequestBody User user ){
        return userService.updateUser(id , user) ;
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable long id ){
        boolean res =  userService.deleteUser(id) ;
        System.out.println(res );
        return res ;

    }

}
