package com.example.quest.services;

import com.example.quest.entities.User;
import com.example.quest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User newUser){
        return this.userRepository.save(newUser);
    }

    public User getOneUser(Long userId){
        return this.userRepository.findById(userId).orElse(null);
    }

    public User updateUser(Long userId, User user){
        User user1 =  this.userRepository.findById(userId).orElse(null);
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        this.userRepository.save(user1);
        return user1;
    }

    public void deleteUser(Long userId){
        this.userRepository.deleteById(userId);
    }
}