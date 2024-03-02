package com.example.hibernate.HibernateCrashLearning.services;// UserService.java

import com.example.hibernate.HibernateCrashLearning.entity.User;
import com.example.hibernate.HibernateCrashLearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
