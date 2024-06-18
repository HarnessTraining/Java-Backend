package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.model.User;
import com.virtusa.project.PgRental.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepository;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    // You can modify this method to return just the user ID if needed
    public Long getUserId(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return (user != null) ? user.getUserId() : null;
    }

}