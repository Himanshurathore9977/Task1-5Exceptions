package com.example.user.service;

import com.example.user.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser() ;
    User createUser(User user) ;
    User updateUser(long id , User user ) ;
    User getUserById(long id) ;

    boolean deleteUser(long id);
}
