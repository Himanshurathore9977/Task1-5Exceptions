package com.example.securityexample.service;

import com.example.securityexample.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> user = new ArrayList<>() ;

    public UserService() {
        user.add(new User(UUID.randomUUID().toString(), "Himanshu" , "Indore ")) ;
        user.add(new User(UUID.randomUUID().toString() , "dvdcv" , "Indor ")) ;
        user.add(new User(UUID.randomUUID().toString(), "cdcd" , "Indo ")) ;
        user.add(new User(UUID.randomUUID().toString(), "dvd" , "Inde ")) ;
        user.add(new User(UUID.randomUUID().toString() , "vdvdv" , "dore ")) ;
    }

    public List<User> getUser() {
        return this.user;
    }
}
