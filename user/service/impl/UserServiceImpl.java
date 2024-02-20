package com.example.user.service.impl;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository ;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll() ;
    }

    @Override
    public User getUserById(long id) {
        Optional<User> user  = userRepository.findById(id) ;
        return user.orElse(null);
    }

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(long id , User updateUser) {
        Optional<User> opUser = userRepository.findById(id) ;
        if(opUser.isPresent()){
            User user = opUser.get() ;
            if(updateUser.getName() != null ){
                user.setName(updateUser.getName());
            }
            if(updateUser.getAddress() != null ){
                user.setAddress(updateUser.getAddress());
            }
            return userRepository.save(user) ;
        }
        return null;
    }

    @Override
    public boolean deleteUser(long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
