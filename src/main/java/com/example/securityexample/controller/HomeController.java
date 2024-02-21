package com.example.securityexample.controller;

import com.example.securityexample.entity.User;
import com.example.securityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserService userService ;

    @GetMapping("/user")
    public List<User> getUser(){
        System.out.println("Getting User ");
        return this.userService.getUser() ;
    }
    @GetMapping("/current-user")
    public String currentUser(Principal principal){
        return principal.getName() ;
    }
    @GetMapping("/proUser")
    public String protectedApi(){
        System.out.println("Pro user ");
        return "I am protected" ;
    }
}
